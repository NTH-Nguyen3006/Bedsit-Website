package com.example.ahihi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ahihi.entities.User;
import com.example.ahihi.repository.UserRepository;
import com.example.ahihi.sevices.UserService;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/admin/user/")
    public String adminPage(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "admin/user/index";
    }

    @RequestMapping(value = "/admin/user/create") // Default = HTTP/GET
    public String adminCreateUserPage(@ModelAttribute("newUser") User newUser) {
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("newUser") User newUser) {
        this.userService.saveUserService(newUser);
        return "redirect:";
    }

    @RequestMapping(value = "/client")
    public String clientPage(Model model) {

        return "hello";
    }
}