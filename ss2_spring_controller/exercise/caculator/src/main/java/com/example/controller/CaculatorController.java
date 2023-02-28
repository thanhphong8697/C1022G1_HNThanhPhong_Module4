package com.example.controller;

import com.example.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/caculator")
public class CaculatorController {
    @Autowired
    ICaculatorService iCaculatorService;
    @GetMapping("")
    public String caculate(@RequestParam(required = false) Double numberFirst, Double numberSecond, String method, Model model) {
        if (numberFirst ==  null & numberSecond == null){
            return "/caculator";
        }
        double result = iCaculatorService.caculate(numberFirst,numberSecond,method);
        String message = "";
        if (result == 0){
            message = "Nhap so khac 0";
        }
        model.addAttribute("number1", numberFirst);
        model.addAttribute("number2", numberSecond);
        model.addAttribute("results", result);
        model.addAttribute("messages", message);
        return "/caculator";
    }

}
