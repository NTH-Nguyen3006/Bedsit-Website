package com.example.ahihi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ahihi.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles findRolesById(int Id);
}
