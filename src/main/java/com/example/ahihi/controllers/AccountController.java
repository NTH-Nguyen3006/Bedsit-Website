package com.example.ahihi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.example.ahihi.entities.User;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());

        // System.out.println(endpointDetails.toString());

        return "pages/account/login";
    }

    @PostMapping(value = "/login")
    public String loginPage(@ModelAttribute("user") User user, Model model) {
        return "pages/account/login";
    }

    @GetMapping(value = "/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());

        return "pages/account/register";
    }

    @PostMapping(value = "/register")
    public String registerPage() {
        return "pages/account/register";
    }

    @PostMapping(value = "/forgot-password")
    public String getPasswordPage() {
        return "pages/account/forgot-password";
    }

}
