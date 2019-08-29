package com.test.springboot01.controller;

import com.test.springboot01.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping("/charts.html")
    public String personList(Model model){
        model.addAttribute("persons",personService.personList());
        return "charts";
    }
}
