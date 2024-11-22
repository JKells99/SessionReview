package com.keyin.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AutorRepository autorRepository;

    public Iterable<Author> getAllAuthors() {
        return autorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return autorRepository.save(author);
    }

    public Author findByAuthorLastName(String lastName) {

        return autorRepository.findAuthorByLastName(lastName);
    }
}
