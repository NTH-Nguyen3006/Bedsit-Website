package com.example.ahihi.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ahihi.repository.UserRepository;
import com.example.ahihi.sevices.UserService;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    private ApplicationContext context;

    public UserController(UserService userService, UserRepository userRepository, ApplicationContext context) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.context = context;
    }

    @GetMapping(value = "/")
    public String homePage(Model model) {
        model.addAttribute("test", "ahihi");

        return "home";
    }

    @RequestMapping(value = "/client")
    public String clientPage(Model model) {
        return "hello";
    }
}