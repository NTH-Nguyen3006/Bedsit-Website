package com.example.ahihi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ahihi.entities.RoomDetails;

public interface RoomDetailsRepository extends JpaRepository<RoomDetails, Integer> {

    void deleteRoomDetailsById(int id);
}
