package com.example.ahihi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ahihi.entities.User;
import com.example.ahihi.sevices.AdminService;
import com.example.ahihi.sevices.UserService;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/admin")
    public String indexPage(Model model) {
        adminService.getEndpointsServices("AdminController");
        return "admin/dashboard";
    }

    @GetMapping(value = "/admin/user/create")
    public String adminCreateUserPage() {
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUser(@ModelAttribute("newUser") User newUser) {
        this.userService.saveUserService(newUser);
        return "redirect:";
    }

    @GetMapping("/admin/user")
    public String adminPage(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "admin/user/index";
    }
}
