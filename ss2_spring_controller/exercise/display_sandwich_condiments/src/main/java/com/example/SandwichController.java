package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/save")
    public String display(){
        return "/list";
    }
    @PostMapping("/save")
    public String save (@RequestParam("condiment") String condiment, Model model){
        model.addAttribute("sandwich", condiment);
        return "/list";
    }
}
