package com.keyin.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepo;

    public Iterable<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book createBook(Book book) {
        return bookRepo.save(book);
    }
}
