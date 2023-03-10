package com.example.book_app.controller;

import com.example.book_app.exception.LowThanZeroException;
import com.example.book_app.exception.WrongCodeException;
import com.example.book_app.modelDTO.BookDTO;
import com.example.book_app.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    public IBookService iBookService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("bookDTO", iBookService.listAll());
        return "/List";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam Integer id) throws LowThanZeroException {
        BookDTO bookDTO = iBookService.findById(id);
        if (bookDTO.getQuantity() == 0) {
            throw new LowThanZeroException();
        }
        bookDTO.borrow();
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        iBookService.updateBook(book);
        return "redirect:/book";
    }

    @GetMapping("/back")
    public String back(@RequestParam Integer id, String code) throws WrongCodeException {
        BookDTO bookDTO = iBookService.findById(id);
        bookDTO.giveBack(code);
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        iBookService.updateBook(book);
        return "redirect:/book";
    }
}
