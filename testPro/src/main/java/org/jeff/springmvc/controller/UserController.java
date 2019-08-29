package org.jeff.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.jeff.springmvc.po.User;
import org.jeff.springmvc.service.UserService;

public class UserController {

    private UserService userService;

    /*
    * 跳转到login.jsp
    * */
    public String login(){
        return "login";
    }
    /*
    * 从login.jsp中的表单提交中获取数据并将他们添加到数据库中
    * 如果添加成功，跳转到sucess.jsp，否则跳转到fail.jsp
    * */
    public String insertUser(HttpServletRequest request) throws Exception{
        User user =new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        boolean isSuccess = false;
        isSuccess = userService.insertUser(user);
        if(isSuccess){
            return "success";
        }else {
            return "fail";
        }
    }

}
