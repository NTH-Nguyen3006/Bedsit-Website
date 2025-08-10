package com.example.ahihi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ahihi.entities.RoomDetails;
import com.example.ahihi.sevices.RoomService;

@Controller
public class UserController {

    @Autowired
    RoomService roomService;

    @GetMapping(value = "/")
    public String homePage(Model model) {
        model.addAttribute("roomRecentUpdate", roomService.get10RoomRecentUpdates());
        return "home";
    }

    @RequestMapping(value = "/client")
    public String clientPage(Model model) {
        return "hello";
    }
}