package com.app.controllers;

import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getDataBase(Model model) {
        System.out.println("Success connect to Db!");
        model.addAttribute("userData", userService.getUsersDb());

        return "allUsers";
    }
}
