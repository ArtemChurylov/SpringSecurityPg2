package com.example.SpringSecurityDataBase.controllers;

import com.example.SpringSecurityDataBase.auth.ApplicationUserDaoService;
import com.example.SpringSecurityDataBase.models.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private final ApplicationUserDaoService applicationUserDaoService;

    public LoginController(ApplicationUserDaoService applicationUserDaoService) {
        this.applicationUserDaoService = applicationUserDaoService;
    }


    @GetMapping("/login")
    public String showMyLoginPage() {
        return "loginPage";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/registration")
    public String registration(ApplicationUser user) {
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String createUser(@Valid ApplicationUser user) {
            applicationUserDaoService.save(user);
            return "redirect:/";

    }
}
