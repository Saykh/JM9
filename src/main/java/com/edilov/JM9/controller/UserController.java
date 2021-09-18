package com.edilov.JM9.controller;

import com.edilov.JM9.entity.User;
import com.edilov.JM9.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("admin")
    public String index(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "admin";
    }

    @GetMapping("/admin/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/admin/save")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/admin/update")
    public String update(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String show(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
        return "info";
    }
}
