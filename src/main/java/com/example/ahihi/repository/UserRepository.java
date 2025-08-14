package com.example.ahihi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ahihi.entities.Roles;
import com.example.ahihi.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    User save(User user);

    List<User> findAll();

    User findByUsername(String username);

    User findByRoles(Roles roles);
}
