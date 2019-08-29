package com.test.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                         Map<String,Object> map, HttpSession session ){
        if(!StringUtils.isEmpty(username) && "12345".equals(password)){
            //login success重定向
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //login failed
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
