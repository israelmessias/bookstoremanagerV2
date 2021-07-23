package com.messias.bookstoremanagerv2.author.service;

import com.messias.bookstoremanagerv2.author.dto.AuthorDTO;
import com.messias.bookstoremanagerv2.author.entity.Author;
import com.messias.bookstoremanagerv2.author.map.AuthorMapper;
import com.messias.bookstoremanagerv2.author.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTACE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /*Classe recebe authorDTO, tranforma o authorDTO -> author, atraves do .toMOdel()
     * depois salva o author convertido. E por final author -> authorDTO com .toDTO
     */
    public AuthorDTO create(AuthorDTO authorDTO) {
        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = authorRepository.save(authorToCreate);
        return authorMapper.tODTO(createdAuthor);

    }
}
