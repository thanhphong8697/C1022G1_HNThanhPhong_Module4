package com.example.book_app.service;

import com.example.book_app.Repository.IBookRepository;
import com.example.book_app.modelDTO.BookDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<BookDTO> listAll() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Book> bookList = iBookRepository.findAll();
        BookDTO bookDTO;
        for (Book book : bookList){
            bookDTO = new BookDTO();
            BeanUtils.copyProperties(book, bookDTO);
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public BookDTO findById(int id) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(Objects.requireNonNull(iBookRepository.findById(id).orElse(null)), bookDTO);
        return bookDTO;
    }

    @Override
    public void updateBook(Book book) {
        iBookRepository.save(book);
    }
}
