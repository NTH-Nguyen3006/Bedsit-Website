package com.example.ahihi.repository;

import org.springframework.data.repository.Repository;

import com.example.ahihi.entities.User;

public interface UserRepository extends Repository<User, Long> {
    User save(User user);
}
