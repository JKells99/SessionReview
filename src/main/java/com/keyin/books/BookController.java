package com.keyin.books;

import com.keyin.authors.Author;
import com.keyin.authors.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;


    @GetMapping("/getAllBooks")
    public Iterable<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/createNewBook")
    public Book addBook(@RequestBody Book book) {

        List<Author> updatedAuthorList = new ArrayList<>();
        for (Author author : book.getAuthors()) {
            Optional<Author> authorOptional = Optional.ofNullable(authorService.findByAuthorLastName(author.getLastName()));
            Author author1;
            if (authorOptional.isPresent()) {
                author1 = authorOptional.get();
                updatedAuthorList.add(author);
            } else {

                updatedAuthorList = book.getAuthors();
                authorService.createAuthor(author);
            }

        }
        book.setAuthors(updatedAuthorList);
        return bookService.createBook(book);


    }


}
