package com.example.graphqldemo.wiring;

import com.example.graphqldemo.entity.Post;
import com.example.graphqldemo.repository.AuthorRepository;
import com.example.graphqldemo.repository.PostRepository;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.stereotype.Component;

@Component
public class CustomerWiring implements RuntimeWiringConfigurer {

    private final PostRepository postRepository;

    private final AuthorRepository authorRepository;

    public CustomerWiring(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void configure(RuntimeWiring.Builder builder) {
        builder.type("Query", typeWiring -> typeWiring
                        .dataFetcher("allAuthors", environment -> authorRepository.findAll())
                        .dataFetcher("author", environment -> authorRepository.getReferenceById(environment.getArgument("id")))
                        .dataFetcher("post", environment -> postRepository.getReferenceById(environment.getArgument("id")))
                        .dataFetcher("allPosts", environment -> postRepository.findAll()))
                .type("Post", builder1 -> builder1.dataFetcher("author", environment -> {
                    Post post = environment.getSource();
                    return post == null ? null : post.getAuthor();
                }));
    }
}
