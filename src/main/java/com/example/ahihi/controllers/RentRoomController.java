package com.example.ahihi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ahihi.sevices.RoomService;
import com.example.ahihi.sevices.UserService;

@Controller
public class RentRoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    UserService userService;

    @GetMapping("/rent-room")
    public String rentRoomPage(Model model, @PageableDefault(size = 10, page = 1) Pageable page) {
        page = page.withPage(page.getPageNumber() - 1);
        model.addAttribute("activePage", "rent-room");
        model.addAttribute("contractPhone", userService.getAdmin().getPhoneNumber());

        model.addAttribute("rooms", this.roomService.getAllRoomDesc(page));
        return "pages/rent-room";
    }

    @GetMapping("/rent-room/view/{id}")
    public String getMethodName(Model model, @PathVariable("id") String id) {
        model.addAttribute("room", this.roomService.getRoomById(id));
        model.addAttribute("activePage", "rent-room");
        model.addAttribute("contractPhone", userService.getAdmin().getPhoneNumber());
        return "pages/room-preview";
    }
}
