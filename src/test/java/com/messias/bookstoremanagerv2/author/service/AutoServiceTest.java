package com.messias.bookstoremanagerv2.author.service;

import com.messias.bookstoremanagerv2.author.builder.AuthorDTOBuilder;
import com.messias.bookstoremanagerv2.author.dto.AuthorDTO;
import com.messias.bookstoremanagerv2.author.entity.Author;
import com.messias.bookstoremanagerv2.author.exception.AuthorAlreadyExistsException;
import com.messias.bookstoremanagerv2.author.map.AuthorMapper;
import com.messias.bookstoremanagerv2.author.repository.AuthorRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.assertj.core.error.AssertionErrorCreator;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.AssertionErrors;

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

    //Quando o novo autor é informado, ele deve ser criado
    @Test
    void whenNewAuthorIsInformedThenItShouldBeCreated()
     {
        //given
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

        //when
        when(authorRepository.save(expectedCreatedAuthor)).thenReturn(expectedCreatedAuthor);
        when(authorRepository.findByName(expectedAuthorToCreateDTO.getNome())).thenReturn(Optional.empty());

        AuthorDTO createdAuthorDTO = authorService.create(expectedAuthorToCreateDTO);

        //then
        assertThat(createdAuthorDTO, Is.is(expectedAuthorToCreateDTO));
    }

    //Quando o autor existente é informado, então uma exceção deve ser lançada
    @Test
    void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown()
     {
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

        when(authorRepository.findByName(expectedAuthorToCreateDTO.getNome()))
                .thenReturn(Optional.of(expectedCreatedAuthor));

        Assert.assertThrows(AuthorAlreadyExistsException.class, () -> authorService.create(expectedAuthorToCreateDTO));
    }

}
