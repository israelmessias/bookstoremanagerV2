package com.messias.bookstoremanagerv2.user.repository;

import com.messias.bookstoremanagerv2.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
