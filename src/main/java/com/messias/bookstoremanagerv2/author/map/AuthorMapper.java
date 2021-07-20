package com.messias.bookstoremanagerv2.author.map;

import com.messias.bookstoremanagerv2.author.dto.AuthorDTO;
import com.messias.bookstoremanagerv2.author.entity.Author;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTACE = Mappers.getMapper(AuthorMapper.class);

    /*O toModel e toDTO, realizam a conversão de uma entidade para DTO 
     e um DTO para uma entidade*/
    Author toModel(AuthorDTO authorDTO);

    AuthorDTO tODTO(Author author);
}
