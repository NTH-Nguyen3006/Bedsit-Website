package com.example.ahihi.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahihi.entities.Roles;
import com.example.ahihi.repository.RolesRepository;

@Service
public class RolesService {
    @Autowired
    public RolesRepository roleRepository;

    public List<Roles> getAllRole() {
        return this.roleRepository.findAll();
    }

    public Roles getRoleById(int id) {
        return this.roleRepository.findRolesById(id);
    }
}
