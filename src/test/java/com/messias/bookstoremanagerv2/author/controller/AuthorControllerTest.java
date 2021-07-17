package com.messias.bookstoremanagerv2.author.controller;

import com.messias.bookstoremanagerv2.author.service.AuthorService;
import com.messias.bookstoremanagerv2.author.builder.AuthorDTOBuilder;
import com.messias.bookstoremanagerv2.author.controller.AuthorController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    private MockMvc mockMvc;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp() {
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).
        setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).
                setViewResolvers(((viewName, locale) -> new MappingJackson2JsonView()))
                .build();
        
    }
}
