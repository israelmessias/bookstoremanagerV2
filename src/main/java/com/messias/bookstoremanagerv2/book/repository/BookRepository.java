package com.messias.bookstoremanagerv2.book.repository;

import com.messias.bookstoremanagerv2.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
