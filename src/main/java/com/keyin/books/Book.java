package com.keyin.books;

import com.keyin.authors.Author;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany
    private List<Author> authors = new ArrayList<>();

    public Book(Long id, String title, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
