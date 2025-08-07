package com.example.ahihi.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ahihi.entities.Roles;
import com.example.ahihi.entities.User;
import com.example.ahihi.sevices.RolesService;
import com.example.ahihi.sevices.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private RolesService roleService;

    @Autowired
    private UserService userService;

    @GetMapping(value = { "/", "" })
    public String adminUserPage(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "admin/user/index";
    }

    @GetMapping(value = "/create")
    public String adminCreateUserPage(Model model) {
        model.addAttribute("roles", this.roleService.getAllRole());
        return "admin/user/create";
    }

    @PostMapping(value = "/create")
    public String createUser(@ModelAttribute("newUser") User newUser) {
        this.userService.saveUserService(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping("/role/{id}")
    @ResponseBody
    public Roles requestMethodName(@PathVariable int id) {
        var role = this.roleService.getRoleById(id);
        return role;
    }

}
