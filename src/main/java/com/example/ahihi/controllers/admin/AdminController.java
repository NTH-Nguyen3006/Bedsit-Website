package com.example.ahihi.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ahihi.repository.RoleRepository;
import com.example.ahihi.sevices.AdminService;
import com.example.ahihi.sevices.RoomService;
import com.example.ahihi.sevices.UserService;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    AdminService adminService;

    @GetMapping(value = { "/", "" })
    public String indexPage(Model model) {
        model.addAttribute("roomCount", roomService.roomCount());
        model.addAttribute("availableRoomCount", roomService.availableRoomCount());
        model.addAttribute("rentedRoomCount", roomService.rentRoomCount());
        model.addAttribute("repairRoomCount",
                roomService.roomCount() - (roomService.availableRoomCount() +
                        roomService.rentRoomCount()));
        model.addAttribute("userCount", userService.getAllUser().size());
        return "admin/dashboard";
    }
}
