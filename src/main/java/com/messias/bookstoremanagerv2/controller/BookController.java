package com.messias.bookstoremanagerv2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/books")
public class BookController {

    @GetMapping
    public String mensage(){
        return "Hello World";
    }
}
