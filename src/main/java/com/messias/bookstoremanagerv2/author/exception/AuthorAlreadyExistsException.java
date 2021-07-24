package com.messias.bookstoremanagerv2.author.exception;

import javax.persistence.EntityExistsException;

import com.fasterxml.jackson.core.sym.Name;

/*
Caso o erro seja EntityExistsException
será enviado para um metodo no BookStoreException e retornara uma mensagem 
customizada para o usuario.
*/
public class AuthorAlreadyExistsException extends EntityExistsException{
    public AuthorAlreadyExistsException(String nome){
        super(String.format("Nome do author %s ja existe!", nome));
    }
}
