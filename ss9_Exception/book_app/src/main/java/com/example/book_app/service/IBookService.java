package com.example.book_app.service;

import com.example.book_app.modelDTO.BookDTO;

import java.awt.print.Book;
import java.util.List;

public interface IBookService {
    List<BookDTO> listAll();
    BookDTO findById(int id);
    void updateBook(Book book);
}
