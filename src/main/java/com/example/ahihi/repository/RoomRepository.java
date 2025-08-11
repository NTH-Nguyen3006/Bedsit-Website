package com.example.ahihi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ahihi.entities.Room;
import com.example.ahihi.entities.Room.Status;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findByStatus(Status status);

    Room findRoomById(String id);

    List<Room> findTop10ByOrderByUpdatedAtDesc();

    Page<Room> findAllByOrderByUpdatedAtDesc(Pageable pageable);

    Page<Room> findAll(Pageable pageable);
}