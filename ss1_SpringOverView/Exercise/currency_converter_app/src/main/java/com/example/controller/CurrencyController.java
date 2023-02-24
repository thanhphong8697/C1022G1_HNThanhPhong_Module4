package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/currency")
    public String converter(@RequestParam(required = false) Double USD, Model model) {
        if (USD == null) {
            model.addAttribute("usd", USD);
            return "/currency";
        }
        double VND = USD * 23000;
        model.addAttribute("vnd", VND);
        model.addAttribute("usd", USD);
        return "/currency";
    }
}
