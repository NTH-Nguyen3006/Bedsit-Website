package com.example.ahihi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ahihi.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

}
