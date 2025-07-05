package com.example.ahihi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.Model;

@Controller
public class UserController {

    @RequestMapping("/admin")
    public String adminPage(Model model) {
        return "admin/index";
    }

    @RequestMapping("/admin/user/create")
    public String adminCreateUserPage(Model model) {
        return "admin/user/create";
    }

    @RequestMapping("/client")
    public String clientPage(Model model) {
        return "hello";
    }
}
