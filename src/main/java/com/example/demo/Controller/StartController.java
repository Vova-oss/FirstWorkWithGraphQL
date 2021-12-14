package com.example.demo.Controller;

import com.example.demo.Service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class StartController {

    @Autowired
    GraphQLService graphQLService;

    @PostMapping("/getAll")
    public ResponseEntity<Object> getAll(@RequestBody String query){
        ExecutionResult executionResult = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }

}
