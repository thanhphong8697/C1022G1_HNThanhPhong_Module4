package com.example.book_app.service;

import com.example.book_app.Repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> listAll() {
        return iBookRepository.findAll();
    }
}
