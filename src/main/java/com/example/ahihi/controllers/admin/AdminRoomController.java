package com.example.ahihi.controllers.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahihi.entities.Room;
import com.example.ahihi.entities.RoomDetails;
import com.example.ahihi.sevices.RoomService;

@Controller
@RequestMapping(path = "/admin/room")
public class AdminRoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping(value = { "", "/" })
    public String adminRoomPage(Model model) {
        model.addAttribute("rooms", this.roomService.getAllRoom());
        return "admin/room/index";
    }

    @GetMapping(value = "/create")
    public String adminRoomCreatePage(Model model) {
        model.addAttribute("rooms", this.roomService.getAllRoom());
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

        System.out.println(this.getClass().getResource("/").getPath());
        // if (!Files.exists(uploadPath))
        // try {
        // Files.createDirectories(uploadPath);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // System.out.println(uploadPath.toString());

        // images.forEach(img -> {
        // // System.out.println(img.getOriginalFilename());
        // // RoomDetails.builder().imageURL("");
        // Path filePath = uploadPath.resolve(roomId + "-" + new Date().getTime());
        // try {
        // Files.copy(img.getInputStream(), filePath,
        // StandardCopyOption.REPLACE_EXISTING);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // });

        return "redirect:./";
    }
}
