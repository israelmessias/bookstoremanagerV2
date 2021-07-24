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

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.assertj.core.error.AssertionErrorCreator;
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

    //Quando o novo autor for informado, então deve ser criado
    @Test
    void whenNewAuthorIsInformedThenItShouldBeCreated() {
        //dados
        AuthorDTO expectdAuthorDTO =  authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectdAuthorDTO);

        //quando expectedCreatedAuthor(toModel()) for salvo retornara expectedCreatedAuthor
        Mockito.when(authorRepository.save(expectedCreatedAuthor))
            .thenReturn(expectedCreatedAuthor);
        Mockito.when(authorRepository.findByName(expectedCreatedAuthor.getNome()))
            .thenReturn(Optional.empty());
        AuthorDTO createdAuthorDTO = authorService.create(expectdAuthorDTO);

        //então ele confirma se createdAuthorDTO
        MatcherAssert.assertThat(createdAuthorDTO, 
        Is.is(IsEqual.equalTo(expectdAuthorDTO)));
    }

    /*Teste para confirmar mensagem de erro customizada,
    quando um nome é repetido no author.
    */
    @Test
    void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown() {
        //dados
        AuthorDTO expectdAuthorDTO =  authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectdAuthorDTO);

        //quando expectedCreatedAuthor(toModel()) for salvo retornara expectedCreatedAuthor
        Mockito.when(authorRepository.findByName(expectedCreatedAuthor.getNome()))
            .thenReturn(Optional.of(expectedCreatedAuthor));

        Assert.assertThrows(AuthorAlreadyExistsException.class, 
        () -> authorService.create(expectdAuthorDTO));
    }
    
}
