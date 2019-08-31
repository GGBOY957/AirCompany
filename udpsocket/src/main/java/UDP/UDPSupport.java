package UDP;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author zwb
 * @date 2019/8/28 - 16:56
 **/
public class UDPSupport {
    //IP地址转换
    public static InetAddress IPConvert(String str) throws IOException {
        String[] ipStr = str.split("\\.");
        byte[] ipBuf = new byte[4];
        for (int i = 0; i < 4; i++) {
            ipBuf[i] = (byte) (Integer.parseInt(ipStr[i]) & 0xff);
        }
        InetAddress address = InetAddress.getByAddress(ipBuf);
        return address;
    }

    //发送包转换
    public static byte[] SendMsgConvert(String str){
        if (str == null || str.trim().equals("")){
            return new byte[0];
        }
        byte[] bytes = new byte[str.length()/2];
        for (int i=0; i<str.length()/2;i++){
            String subStr = str.substring(i*2,i*2+2);
            bytes[i]= (byte)Integer.parseInt(subStr,16);
        }
        return bytes;
    }

    //16进制byte转换为String
    public static String getBufHexStr(byte[] raw){
        String HEXES="0123456789ABCDEF";
        if(raw==null){
            return  null;
        }
        final StringBuilder hex=new StringBuilder(2*raw.length);
        for(final byte b:raw){
            hex.append(HEXES.charAt((b&0xF0)>>4)).append(HEXES.charAt((b&0x0F)));
        }
        return hex.toString();
    }

    //注册返回包生成数据发送包
    public static String fromConnecttoMsg20Voltage(String str){
        String msg = new String();
        String CkSum = "0201201100000000"+str.substring(20,26)+
                "0000008000"+"0304000000027029";
        msg = msg+"5A450201201100000000"+str.substring(20,26)+
                "0000008000"+"0304000000027029"+getCkSum(CkSum)+"16";

        return msg;
    }

    //计算CkSum
    public static String getCkSum(String CkSum){
        byte[] ck = SendMsgConvert(CkSum);
        int sum = 0 ;
        int temp;
        for (int i = 0;i<ck.length;i++){
            if(ck[i]<0){
                temp=ck[i]+256;
            }
            else temp=ck[i];
            if((sum+temp)>=256) {
                sum = sum + temp - 256;
            }
            else {
                sum = sum + temp;
            }
        }
//        System.out.println("finalsum:"+sum);
        String s =Integer.toHexString(sum);
        if(s.length()==1){
            s = "0" + s;
        }
//        System.out.println(s);
        return s;
    }

    //port 转换为 总线ID
    public static String portToHighwayID(String string){
        String ID="";
        switch (string){
            case "2000":
                ID = "1";
                break;
            case "3000":
                ID = "2";
                break;
            case "4000":
                ID = "3";
                break;
            case "5000":
                ID = "4";
                break;
            case "6000":
                ID = "5";
                break;
            case "7000":
                ID = "6";
                break;
                default:
                    break;
        }
        return ID;
    }

    //总线ID 转换为 port
    public static String HighwayIDToport(String string){
        String port="";
        switch (string){
            case "1":
                port = "2000";
                break;
            case "2":
                port = "3000";
                break;
            case "3":
                port = "4000";
                break;
            case "4":
                port = "5000";
                break;
            case "5":
                port = "6000";
                break;
            case "6":
                port = "7000";
                break;
            default:
                break;
        }
        return port;
    }

    //返回设备ID
    public static String getEquipmentID(String string){
        if (string.length()>26){
            return string.substring(4,6);
        }
        return "未获得ID！";
    }

    //返回总线ID
    public static String getHighwayID(String string){
        return portToHighwayID(string);
    }

    //获得返回数据的时间戳
    public static String getTime(String string){
        if (string.length()>26){
            return string.substring(20,26);
        }
        return "未获得时间戳！";
    }

    //获得设备数据
    public static String getDataVoltage(String string){
        byte[] fromData;
        if (string.length()>26){
            fromData = SendMsgConvert(string.substring(42,50));
            int bits = fromData[3]&0xff|(fromData[2]&0xff)<<8|(fromData[1]&0xff)<<16|(fromData[0]&0xff)<<24;
            int sign = ((bits&0x80000000)==0)?1:-1;
            int exp = ((bits & 0x7f800000)>>23);
            int man = (bits & 0x007fffff);

            man |= 0x00800000;

            float f = (float)(sign*man*Math.pow(2,exp - 150));
            return "电压："+Float.toString(f);
        }
        return "未获得数据！";
    }

    public static String Tag;
    //存储设备标签
    public static void setTag(String tag) {
        Tag = tag;
    }
    //获取设备标签
    public static String getTag() {
        Tag = "电表";
        return Tag;
    }
}
