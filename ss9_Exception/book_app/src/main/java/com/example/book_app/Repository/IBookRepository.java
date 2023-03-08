package com.example.book_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
