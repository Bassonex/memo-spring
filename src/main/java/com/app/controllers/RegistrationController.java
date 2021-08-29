package com.app.controllers;

import com.app.model.User;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userData", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String successRegistration(@ModelAttribute User user, Model model){
        User newUser = userService.validateUser(user);
        model.addAttribute("status", newUser == null ? "error" : "success");
        model.addAttribute("user", user);
        return "allUsers";
    }
}
