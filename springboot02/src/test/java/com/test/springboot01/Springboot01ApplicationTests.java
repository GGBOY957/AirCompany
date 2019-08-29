package com.test.springboot01;

import com.test.springboot01.bean.Person;
//import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {

//        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHH");
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
//        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHH");
        System.out.println(connection);
        connection.close();
    }

}
