package com.example.ahihi.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
