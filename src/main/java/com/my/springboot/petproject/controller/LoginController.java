package com.my.springboot.petproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showMyLoginPage() {
        System.out.println("Entered Login");
        return "login-page";
    }
}
