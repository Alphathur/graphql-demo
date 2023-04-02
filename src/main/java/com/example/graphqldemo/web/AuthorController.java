package com.example.graphqldemo.web;

import com.example.graphqldemo.entity.Author;
import com.example.graphqldemo.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("{id}")
    public Author getOne(@PathVariable Integer id) {
        return authorRepository.getReferenceById(id);
    }

    @GetMapping
    public List<Author> all() {
        return authorRepository.findAll();
    }
}
