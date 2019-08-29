package com.test.springboot01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

//@Controller
public class hellocontroller {

    @Value("${person.last-name}")
    private String name;

    @RequestMapping({"/","/login.html"})
    public String index(){
        return "login";
    }
//    @RequestMapping("charts.html")
//    public String charts(){
//        return "charts";
//    }

    @ResponseBody
    @RequestMapping("/hell")
    public String hello(){

        return "hello world"+name;
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>hello</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
