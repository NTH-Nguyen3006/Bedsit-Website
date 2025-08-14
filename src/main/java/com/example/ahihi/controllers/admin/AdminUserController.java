package com.example.ahihi.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.example.ahihi.entities.Roles;
import com.example.ahihi.entities.User;
import com.example.ahihi.sevices.RolesService;
import com.example.ahihi.sevices.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin/user")
@Slf4j
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
        var newUser = new User();
        newUser.setRoles(new Roles());
        model.addAttribute("roles", this.roleService.getAllRole());
        model.addAttribute("newRole", new Roles());
        model.addAttribute("newUser", newUser);
        return "admin/user/create";
    }

    @PostMapping(value = "/create")
    public String createUser(@ModelAttribute("newUser") User newUser) {
        log.info("create user: " + newUser);
        this.userService.saveUserService(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping(value = "/update/{id}")
    public String adminUpdateUserPage(Model model, @PathVariable("id") String username) {
        model.addAttribute("user", this.userService.getUserByUsername(username));
        model.addAttribute("roles", this.roleService.getAllRole());
        model.addAttribute("newRole", new Roles());
        return "admin/user/update";
    }

    @PostMapping(value = "/update/")
    public String updateUser(Model model, @ModelAttribute("newUser") User user) {
        System.out.println(user);

        return "admin/user/update";
    }

    @GetMapping(value = "/delete/{id}")
    public String adminDeleteUserPage(Model model, @PathVariable("id") String username) {
        model.addAttribute("user", this.userService.getUserByUsername(username));
        return "admin/user/delete";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") String username) {
        userService.deleteUser(username);
        return "redirect:/admin/user";
    }

    @GetMapping("/role/{id}")
    @ResponseBody
    public Roles getRole(@PathVariable("id") int id) {
        var role = this.roleService.getRoleById(id);
        System.out.println(role);
        return role;
    }

    @PostMapping("/role/create")
    public RedirectView createRole(@ModelAttribute("newRole") Roles roles) {
        roleService.save(roles);
        log.info("Create Role: " + roles);
        return new RedirectView("/admin/user/create");
    }

    @PostMapping("/role/delete/{id}")
    public ResponseEntity<String> deleleRole(@PathVariable("id") int id) {
        roleService.delete(id);
        return ResponseEntity.ok("deleted role");
    }

}
