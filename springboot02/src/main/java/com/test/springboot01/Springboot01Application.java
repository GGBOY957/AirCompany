package com.test.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {

        SpringApplication.run(Springboot01Application.class, args);
    }

    public ViewResolver myViewReolver(){
        return new MyViewResolver();
    }
    private  static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
