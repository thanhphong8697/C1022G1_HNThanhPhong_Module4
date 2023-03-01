package com.example.controller;

import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/list")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public String showList(@RequestParam(required = false) String nameSearch, Model model){
        model.addAttribute(iProductService.listProduct(nameSearch));
        return "/list";

    }
}
