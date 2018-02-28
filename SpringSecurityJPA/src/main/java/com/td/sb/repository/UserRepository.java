package com.td.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.td.sb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}