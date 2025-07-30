package com.example.ahihi.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahihi.entities.Roles;
import com.example.ahihi.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Roles> getAllRole() {
        return this.roleRepository.findAll();
    }
}
