package com.example.graphqldemo.web;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.execution.GraphQlSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("graphql")
public class GraphQLController {

    private final GraphQL graphQL;

    @Autowired
    public GraphQLController(GraphQlSource graphQlSource) {
        graphQL = graphQlSource.graphQl();
    }

    @PostMapping("query")
    public ResponseEntity<Object> query(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return ResponseEntity.ok(result.getData());
    }
}
