package com.example.ahihi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ahihi.sevices.RoomService;
import com.example.ahihi.sevices.UserService;

@Controller
public class RentRoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    UserService userService;

    @GetMapping("/rent-room")
    public String getMethodName(Model model, @PageableDefault(size = 10) Pageable page) {
        model.addAttribute("activePage", "rent-room");
        model.addAttribute("contractPhone", userService.getAdmin().getPhoneNumber());
        model.addAttribute("rooms", this.roomService.getAllRoomDesc(page));
        return "pages/rent-room";
    }
}
