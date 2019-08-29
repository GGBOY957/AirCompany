package com.test.springboot01.controller;

import com.test.springboot01.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserListController {

    @Autowired
    UsersService usersService;

    @RequestMapping("/UserList")
    public String userList(Model model){
        model.addAttribute("users",usersService.usersonList());
        return "user_list";
    }

//    @RequestMapping("/UserDelete/{id}")
//    public  Boolean deleteUser(@PathVariable("id") Integer id){
//        usersService.delete(id);
//
//    }
}
