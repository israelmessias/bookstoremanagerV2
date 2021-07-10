package com.messias.bookstoremanagerv2.author.repository;

import com.messias.bookstoremanagerv2.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
