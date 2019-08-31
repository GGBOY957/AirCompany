package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    //定义服务器的地址、端口号
    public static String str = "192.168.0.240";
    public static int port = 2000;
        //public static String str = "192.168.0.3";
        //public static int port = 8080;
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String datamsg ;
        //注册设备，并获取带有是时间戳的返回值
        datamsg = "534E02AAFF16AAAA33337B16";
        String connectToMsg = Connect(socket,datamsg);

        //根据带有时间戳的返回值生成访问的msg
//        不变：5A450201201100000000
//                时间戳：A7E700
//                不变：0000008000
//                查询电表数据：0304000000027029
//                距离计算：E4
//                结束：16
//        datamsg = "5A450201201100000000A7E70000000080000304000000027029E416";
        int count = 1;
        //从连接到数据发送
        datamsg = UDPSupport.fromConnecttoMsg20Voltage(connectToMsg);
        String fromAmmeter=getbackmsg(socket,datamsg);

        System.out.println("第"+count+"次："+"设备ID："+UDPSupport.getEquipmentID(fromAmmeter)+"——总线ID："+UDPSupport.getHighwayID(Integer.toString(port))
                +"——时间戳："+UDPSupport.getTime(fromAmmeter)+"——数据信息："+UDPSupport.getDataVoltage(fromAmmeter)+"——设备标签："+UDPSupport.getTag());
        count++;
        while (true) {
            try {
                Thread.sleep(2000);

                datamsg = UDPSupport.fromConnecttoMsg20Voltage(fromAmmeter);
                System.out.println(datamsg);
                fromAmmeter = getbackmsg(socket, datamsg);

                System.out.println("第"+count+"次："+"设备ID：" + UDPSupport.getEquipmentID(fromAmmeter) + "——总线ID：" + UDPSupport.getHighwayID(Integer.toString(port))
                        + "——时间戳：" + UDPSupport.getTime(fromAmmeter) + "——数据信息：" + UDPSupport.getDataVoltage(fromAmmeter) + "——设备标签：" + UDPSupport.getTag());
                count++;
//                socket.
            } catch (Exception e) {
                System.out.println("失败:" + e);
            }
        }
        //从数据返回到数据发送
//        datamsg = UDPSupport.fromConnecttoMsg20Voltage(fromAmmeter);
//        fromAmmeter=getbackmsg(socket,datamsg);
//        System.out.println(fromAmmeter);
//        System.out.println("设备ID："+UDPSupport.getEquipmentID(fromAmmeter)+"——总线ID："+UDPSupport.getHighwayID(Integer.toString(port))
//                +"——时间戳："+UDPSupport.getTime(fromAmmeter)+"——数据信息："+UDPSupport.getDataVoltage(fromAmmeter)+"——设备标签："+UDPSupport.getTag());
//        socket.close();
    }

//连接函数
    public static String Connect(DatagramSocket socket,String datamsg) throws IOException{
        String back = new String();
        InetAddress address = UDPSupport.IPConvert(str);
        byte[] data1 = UDPSupport.SendMsgConvert(datamsg);
        DatagramPacket packet = new DatagramPacket(data1, data1.length, address, port);
        socket.send(packet);

        byte[] data2 = new byte[14];
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
        for (int i=0;i<4;i++)
        {
            try{
                socket.receive(packet2);
                String reply = UDPSupport.getBufHexStr(packet2.getData());
                if(reply.substring(4,6).equals("20")){ back = reply;}
            }catch (Exception e){
                break;
            }
        }
        return back;
    }
//查询电表数据
    public static String getbackmsg(DatagramSocket socket,String datamsg)throws IOException{
        InetAddress address = UDPSupport.IPConvert(str);
        byte[] data1 = UDPSupport.SendMsgConvert(datamsg);
        DatagramPacket packet1 = new DatagramPacket(data1, data1.length, address, port);
        socket.send(packet1);
        byte[] data2 = new byte[29];
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
        socket.receive(packet2);
        String reply = UDPSupport.getBufHexStr(packet2.getData());
        return reply;
    }
}
