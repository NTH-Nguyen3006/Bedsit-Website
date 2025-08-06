package com.example.ahihi.controllers.admin;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahihi.entities.Room;
import com.example.ahihi.entities.RoomDetails;
import com.example.ahihi.sevices.RoomService;
import com.example.ahihi.sevices.StorageService;
import org.springframework.web.bind.annotation.RequestBody;

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
            @RequestParam("images") List<MultipartFile> images) {

        System.out.println(rentPrice);

        Room room = Room.builder()
                .id(roomId).area(area).roomType(roomType)
                .decription(description).status((short) status)
                .rentPrice(rentPrice).roomDetails(new HashSet<>())
                .build();

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
        roomService.save(room);
        return room;
    }

    @GetMapping("/update/{id}")
    public String updateRoomPage(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("room", this.roomService.getRoomById(id));
        return "admin/room/update";
    }

    @PostMapping("/update/{id}")
    public Room postMethodName(@PathVariable("id") String id) {

        return entity;
    }

    @GetMapping("/delete/{id}")
    public String deteleRoomPage(Model model, @PathVariable("id") String id) {
        model.addAttribute("id", id);
        return "admin/room/delete";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteRoomReq(@PathVariable("id") String id) {
        System.out.println("id: " + id);
        return "redirect:/admin/room";
    }

}
