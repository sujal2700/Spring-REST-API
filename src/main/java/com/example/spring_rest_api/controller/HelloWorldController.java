package com.example.spring_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // HTTP GET REQUEST
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

}
