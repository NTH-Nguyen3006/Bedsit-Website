package com.example.ahihi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

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