package com.example.graphqldemo.web;

import com.example.graphqldemo.entity.Post;
import com.example.graphqldemo.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostsController {
    private final PostRepository postRepository;

    public PostsController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("{id}")
    public Post getOne(@PathVariable Integer id) {
        return postRepository.getReferenceById(id);
    }

    @GetMapping
    public List<Post> all() {
        return postRepository.findAll();
    }
}
