package com.example.book_app.controller;

import com.example.book_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    public IBookService iBookService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("bookDTO", iBookService.listAll());
        return "/List";
    }
}
