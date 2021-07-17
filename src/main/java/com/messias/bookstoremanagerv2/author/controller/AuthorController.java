package com.messias.bookstoremanagerv2.author.controller;

import com.messias.bookstoremanagerv2.author.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/authors")
public class AuthorController {

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    private AuthorService authorService;

}
