package com.messias.bookstoremanagerv2.author.service;

import com.messias.bookstoremanagerv2.author.builder.AuthorDTOBuilder;
import com.messias.bookstoremanagerv2.author.dto.AuthorDTO;
import com.messias.bookstoremanagerv2.author.map.AuthorMapper;
import com.messias.bookstoremanagerv2.author.repository.AuthorRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AutoServiceTest {

    private final AuthorMapper authorMapper = AuthorMapper.INSTACE;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp(){
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
    }
}
