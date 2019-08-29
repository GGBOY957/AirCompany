package com.test.springboot01.controller;

import com.test.springboot01.bean.Limits;
import com.test.springboot01.service.LimitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//undo 重定向

@Controller
public class LimitsController {

    @Autowired
    LimitsService limitsService;

    @RequestMapping("/LimitsCreat")
   public String creatLimits(Limits limits){
        limitsService.insert(limits);
        return "charts";
    }

//    @RequestMapping("LimitsDelete")
//    public void deleteLimits(Integer id){
//        limitsService.delete(id);
//    }

    @RequestMapping("/LimitsGet/{id}")
    public String getLimits(@PathVariable("id") Integer id, Model model){
        model.addAttribute("limits",limitsService.getById(id));
        return "charts";
    }

    @RequestMapping("/LimitsUpdate")
    public String updateLimits(Limits limits){
        limitsService.update(limits);
        return "charts";
    }

}
