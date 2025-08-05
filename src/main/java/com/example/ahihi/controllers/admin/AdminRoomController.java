package com.example.ahihi.controllers.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahihi.entities.Room;
import com.example.ahihi.entities.RoomDetails;
import com.example.ahihi.sevices.RoomService;
import com.example.ahihi.sevices.StorageService;

@Controller
@RequestMapping(path = "/admin/room")
public class AdminRoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private StorageService storageService;

    @GetMapping(value = { "", "/" })
    public String adminRoomPage(Model model) {
        model.addAttribute("rooms", this.roomService.getAllRoom());
        return "admin/room/index";
    }

    @GetMapping(value = "/create")
    public String adminRoomCreatePage(Model model) {
        // model.addAttribute("rooms", this.roomService.getAllRoom());
        return "admin/room/create";
    }

    @PostMapping(value = "/create")
    public String adminRoomCreatePOST(
            @RequestParam("roomId") String roomId,
            @RequestParam("roomType") String roomType,
            @RequestParam("area") double area,
            @RequestParam("rentPrice") double rentPrice,
            @RequestParam("description") String description,
            @RequestParam("status") int status,
            @RequestParam("images") List<MultipartFile> images) {

        Room room = Room.builder()
                .id(roomId).area(area).roomType(roomType)
                .decription(description).status((short) status)
                .build();

        RoomDetails rDetail;
        java.util.Set<RoomDetails> roomDetails = new HashSet<>();
        int t = 0;
        for (MultipartFile img : images) {
            String filename = String.format("room%s-%d-%d.png", roomId, ++t, new Date().getTime());
            storageService.uploadFile(img, filename);
            rDetail = new RoomDetails();
            rDetail.setImageURL(filename);
            rDetail.setRoom(room);
            roomDetails.add(rDetail);
        }

        room.setRoomDetails(roomDetails);
        roomService.save(room);

        return "redirect:./index.html";
    }
}
