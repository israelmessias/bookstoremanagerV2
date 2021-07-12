package com.messias.bookstoremanagerv2.author.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.messias.bookstoremanagerv2.book.entity.Book;

import com.messias.bookstoremanagerv2.entity.Auditable;
import lombok.Data;

@Data
@Entity
public class Author extends Auditable {
    /*
    Foi criado a entidade de dados Autor 
     Com os id, nome, idade, e a ista de livros*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(columnDefinition = "integer default 0")
    private int age; 
//Um author pode ter uma lista de livros
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    List<Book> books;
}
