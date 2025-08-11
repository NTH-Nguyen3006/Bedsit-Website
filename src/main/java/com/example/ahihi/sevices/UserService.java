package com.example.ahihi.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahihi.entities.User;
import com.example.ahihi.repository.RolesRepository;
import com.example.ahihi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public User saveUserService(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public User getAdmin() {
        var adminRole = rolesRepository.findByRoleName("ADMIN");
        return this.userRepository.findByRoles(adminRole);
    }
}