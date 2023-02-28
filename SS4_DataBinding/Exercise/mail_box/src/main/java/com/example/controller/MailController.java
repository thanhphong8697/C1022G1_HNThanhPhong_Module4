package com.example.controller;

import com.example.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class MailController {
    @Autowired
    IMailService iMailService;
    @GetMapping("/mail")
    public String showMail(Model model){
        model.addAttribute("mailBox", iMailService.mailBox());
        if (iMailService.mailBox().isSpamsFilter()){
            model.addAttribute("spamfilter", "Enable spams filter");
        } else  model.addAttribute("spamfilter", "Disanable spams filter");
        return "/box";
    }
    @GetMapping("/updateForm")
    public String updateForm(Model model){
        model.addAttribute("mailBox", iMailService.mailBox());
        model.addAttribute("language", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizes", Arrays.asList(5, 10, 15, 20, 25, 50, 100));
        return "/update";

    }
}
