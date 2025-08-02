package com.example.ahihi.controllers.admin;

import com.example.ahihi.repository.RoleRepository;
import com.example.ahihi.sevices.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ahihi.entities.User;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = { "/", "" })
    public String adminUserPage(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "admin/user/index";
    }

    @GetMapping(value = "/create")
    public String adminCreateUserPage(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user/create";
    }

    @PostMapping(value = "/create")
    public String createUser(@ModelAttribute("newUser") User newUser) {
        this.userService.saveUserService(newUser);
        return "redirect:/admin/user";
    }
}
