package com.messias.bookstoremanagerv2.author.service;

import com.messias.bookstoremanagerv2.author.map.AuthorMapper;
import com.messias.bookstoremanagerv2.author.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTACE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

}
