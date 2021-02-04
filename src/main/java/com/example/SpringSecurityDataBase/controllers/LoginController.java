package com.example.SpringSecurityDataBase.controllers;

import com.example.SpringSecurityDataBase.auth.ApplicationUserDaoService;
import com.example.SpringSecurityDataBase.auth.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @Autowired
    private final ApplicationUserDaoService applicationUserDaoService;

    public LoginController(ApplicationUserDaoService applicationUserDaoService) {
        this.applicationUserDaoService = applicationUserDaoService;
    }


    @GetMapping("/login")
    public String showMyLoginPage() {
        return "loginPage";
    }

    @GetMapping("/successfulPage")
    public String successfulPage() {
        return "successfulPage";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/registration")
    public String registration(CrmUser crmUser) {
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String createUser(@Valid CrmUser crmUser, BindingResult result) {

        if (result.hasErrors()) {
            return "registrationPage";
        }else {
            applicationUserDaoService.save(crmUser);
            return "redirect:/successfulPage";
        }
    }

}