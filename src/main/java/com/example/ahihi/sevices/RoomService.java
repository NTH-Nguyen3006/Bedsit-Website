package com.example.ahihi.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahihi.entities.Room;
import com.example.ahihi.repository.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public int roomCount() {
        return (int) roomRepository.count();
    }

    public int availableRoomCount() {
        // 0 -> đã thuê, 1 -> chưa thuê;
        return this.roomCount()
                - (this.rentRoomCount() + roomRepository.findByStatus((byte) 2).size());
    }

    public int rentRoomCount() {
        return roomRepository.findByStatus((byte) 0).size();
    }

    public List<Room> getAllRoom() {
        return this.roomRepository.findAll();
    }

    public Room save(Room room) {
        return this.roomRepository.save(room);
    }

    public Room getRoomById(String id) {
        return this.roomRepository.findRoomById(id);
    }
}
