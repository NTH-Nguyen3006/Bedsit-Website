package com.example.ahihi.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ahihi.entities.User;
import com.example.ahihi.repository.RoleRepository;
import com.example.ahihi.sevices.AdminService;
import com.example.ahihi.sevices.RoomService;
import com.example.ahihi.sevices.UserService;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    private final RoleRepository roleRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;

    @Autowired
    AdminService adminService;

    AdminController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

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

    @GetMapping("/user")
    public String adminUserPage(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "admin/user/index";
    }

    @GetMapping(value = "/user/create")
    public String adminCreateUserPage(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user/create";
    }

    @PostMapping(value = "/user/create")
    public String createUser(@ModelAttribute("newUser") User newUser) {
        this.userService.saveUserService(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping(value = "/room")
    public String adminRoomPage(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "admin/room/index";
    }

    @GetMapping(value = "/room/create")
    public String adminRoomCreatePage(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "admin/room/create";
    }

}
