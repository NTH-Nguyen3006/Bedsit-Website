package com.example.ahihi.sevices;

import org.springframework.stereotype.Service;

import com.example.ahihi.entities.User;
import com.example.ahihi.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUserService(User user) {
        return this.repository.save(user);
    }
}