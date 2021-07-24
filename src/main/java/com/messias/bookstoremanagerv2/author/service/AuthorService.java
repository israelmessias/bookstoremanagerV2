package com.messias.bookstoremanagerv2.author.service;

import com.messias.bookstoremanagerv2.author.dto.AuthorDTO;
import com.messias.bookstoremanagerv2.author.entity.Author;
import com.messias.bookstoremanagerv2.author.exception.AuthorAlreadyExistsException;
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

    /*O nome do author é unico, caso venha repetir um nome enviara um erro de banco de dados
     *Para evetiar que apareça um erro de banco de dados, ocorrera uma verificação de tipos nulo
     e depois enviara uma exception. 


     *Classe recebe authorDTO, tranforma o authorDTO -> author, atraves do .toMOdel()
     * depois salva o author convertido. E por final author -> authorDTO com .toDTO
     */
    public AuthorDTO create(AuthorDTO authorDTO) {
        verifyIfExists(authorDTO.getNome());
        
        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = authorRepository.save(authorToCreate);
        return authorMapper.tODTO(createdAuthor);

    }

    private void verifyIfExists(String authorName) {
        authorRepository.findByName(authorName)
            .ifPresent(author -> {throw new AuthorAlreadyExistsException(authorName);});
    }
}
