package com.example.ahihi.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.ahihi.entities.Roles;
import com.example.ahihi.entities.User;

public interface UserRepository extends Repository<User, Long> {
    User save(User user);

    List<User> findAll();

    User findById(long id);

    User findByRoles(Roles roles);
}
