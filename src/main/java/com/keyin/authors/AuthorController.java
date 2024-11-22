package com.keyin.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Iterable<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }
}
