package com.example.ahihi.controllers.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahihi.entities.Room;
import com.example.ahihi.entities.RoomDetails;
import com.example.ahihi.sevices.RoomService;
import com.example.ahihi.sevices.StorageService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(path = "/admin/room")
@Slf4j
public class AdminRoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private StorageService storageService;

    @GetMapping(value = { "", "/" })
    public String adminRoomPage(Model model) {
        model.addAttribute("rooms", this.roomService.getAllRoom());
        // model.addAttribute("roomStatus",
        // Room.Status.values()[room.status].getContent());
        return "admin/room/index";
    }

    @GetMapping(value = "/{id}")
    public String adminRoomDetailPage(Model model, @PathVariable("id") String id) {
        model.addAttribute("room", this.roomService.getRoomById(id));

        return "admin/room/detail";
    }

    @GetMapping(value = "/create")
    public String adminRoomCreatePage(Model model) {
        return "admin/room/create";
    }

    @PostMapping(value = "/create")
    public Room adminRoomCreatePOST(
            @RequestParam("roomId") String roomId,
            @RequestParam("roomType") String roomType,
            @RequestParam("area") double area,
            @RequestParam("rentPrice") double rentPrice,
            @RequestParam("description") String description,
            @RequestParam("status") int status,
            @RequestParam("images") @Nullable List<MultipartFile> images) {

        Room room = Room.builder()
                .id(roomId).area(area).roomType(roomType)
                .decription(description).status(Room.Status.values()[status])
                .rentPrice(rentPrice).roomDetails(new HashSet<>())
                .build();

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
        } else {

        }
        roomService.save(room);
        return room;
    }

    @GetMapping("/update/{id}")
    public String updateRoomPage(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("room", this.roomService.getRoomById(id));
        return "admin/room/update";
    }

    @PutMapping("/update")
    public Room postMethodName(@RequestParam("roomId") String roomId,
            @RequestParam("roomType") String roomType,
            @RequestParam("area") double area,
            @RequestParam("rentPrice") double rentPrice,
            @RequestParam("description") String description,
            @RequestParam("status") int status,
            @RequestParam("images") @Nullable List<MultipartFile> images,
            @RequestParam("imagesToRemove") @Nullable List<String> imagesToRemove) {

        return roomService.updateRoom(
                roomId, roomType, area, rentPrice, description, status, images, imagesToRemove);
    }

    @GetMapping("/delete/{id}")
    public String deteleRoomPage(Model model, @PathVariable("id") String id) {
        model.addAttribute("id", id);
        return "admin/room/delete";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteRoomReq(@PathVariable("id") String id) {
        this.roomService.deleteRoomById(id);
        log.info("Delete Room with id: " + id);
        return "redirect:/admin/room";
    }

}
