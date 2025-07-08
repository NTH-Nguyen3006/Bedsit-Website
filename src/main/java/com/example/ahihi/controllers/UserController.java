package com.example.ahihi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ahihi.entities.User;
import com.example.ahihi.sevices.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/admin")
    public String adminPage(Model model) {
        return "admin/index";
    }

    @RequestMapping("/admin/user/create")
    public String adminCreateUserPage(Model model, @ModelAttribute("newUser") User newUser) {
        System.out.println("xin chao: " + newUser);
        this.userService.saveUserService(newUser);
        return "admin/user/create";
    }

    @RequestMapping("/client")
    public String clientPage(Model model) {

        return "hello";
    }
}