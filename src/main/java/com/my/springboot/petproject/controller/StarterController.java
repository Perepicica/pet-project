package com.my.springboot.petproject.controller;

import com.my.springboot.petproject.entity.RegistrationUser;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StarterController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/login")
    public String showMyLoginPage() {
        return "login-page";
    }

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new RegistrationUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("newUser") RegistrationUser registrationUser,
            BindingResult bindingResult,
            Model model) {
        String userName = registrationUser.getUserName();
        System.out.println("Processing registration form for: " + userName);

        if (bindingResult.hasErrors()) {
            return "registration-form";
        }

        return "home";
    }
}
