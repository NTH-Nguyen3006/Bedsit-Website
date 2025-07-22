package com.example.ahihi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ahihi.entities.User;

@Controller
public class AccountController {

    @GetMapping(value = "/account/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "pages/login";
    }

    @PostMapping(value = "/account/login")
    public String loginPage(@ModelAttribute("user") User user, Model model) {
        return "pages/login";
    }

    @GetMapping(value = "/account/register")
    public String registerPage() {
        return "pages/register";
    }
}
