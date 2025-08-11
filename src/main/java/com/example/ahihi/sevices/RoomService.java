package com.example.ahihi.sevices;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahihi.entities.Room;
import com.example.ahihi.entities.RoomDetails;
import com.example.ahihi.repository.RoomDetailsRepository;
import com.example.ahihi.repository.RoomRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoomService {
    @Autowired
    private RoomDetailsRepository roomDetailsRepository;
    @Autowired
    private StorageService storageService;
    @Autowired
    private RoomRepository roomRepository;

    public int roomCount() {
        return (int) roomRepository.count();
    }

    public int availableRoomCount() {
        return this.roomCount()
                - (this.rentRoomCount() + roomRepository.findByStatus(Room.Status.Available).size());
    }

    public int rentRoomCount() {
        return roomRepository.findByStatus(Room.Status.Rent).size();
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

    public void deleteRoomById(String id) {
        Room entity = this.getRoomById(id);
        entity.getRoomDetails().forEach(rdetail -> storageService.deleteFile(rdetail.getImageURL()));
        this.roomRepository.deleteById(id);
    }

    public Room updateRoom(String roomId,
            String roomType, double area, double rentPrice, String description,
            int status, List<MultipartFile> images, List<String> imagesToRemove) {

        Room room = this.getRoomById(roomId);
        room.setArea(area);
        room.setDecription(description);
        room.setRentPrice(rentPrice);
        room.setStatus(Room.Status.values()[status]);
        room.setRoomType(roomType);

        if (images != null) {
            RoomDetails rDetail;
            int t = 0;
            for (MultipartFile img : images) {
                String filename = String.format("room%s-%d-%d.png", roomId, ++t, new Date().getTime());
                storageService.uploadFile(img, filename);
                rDetail = new RoomDetails();
                rDetail.setImageURL(filename);
                rDetail.setRoom(room);
                room.getRoomDetails().add(rDetail);
            }
            log.info(String.format("Save %d image", images.size()));
        }
        if (imagesToRemove != null) {
            imagesToRemove.forEach(itr -> {
                var rdToDel = room.getRoomDetails().stream()
                        .filter(rd -> rd.getImageURL().equals(itr))
                        .findFirst().get();
                room.getRoomDetails().remove(rdToDel);
                this.roomDetailsRepository.delete(rdToDel);
                storageService.deleteFile(itr);
            });
        }

        return this.save(room);
    }

    public List<Room> get10RoomRecentUpdates() {
        return roomRepository.findTop10ByOrderByUpdatedAtDesc();
    }

    public Page<Room> getAllRoomDesc(Pageable pageable) {
        return this.roomRepository.findAllByOrderByUpdatedAtDesc(pageable);
    }

    public Page<Room> roomPaginated(Pageable pageable) {
        return this.roomRepository.findAll(pageable);
    }
}
