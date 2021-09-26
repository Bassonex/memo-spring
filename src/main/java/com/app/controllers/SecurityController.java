package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/welcome")
    public String getWelcomePage(){
        return "welcome";
    }

    @GetMapping("/dashboard")
    public String getDashboardPage(){
        return "dashboard";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
}
