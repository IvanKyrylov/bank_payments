package com.cursach.controller;

import com.cursach.entity.User;
import com.cursach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Model model, User user) {
        boolean check = userService.add(user);
        if (check) {
            return "redirect:/login";
        } else {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
    }
    @GetMapping("/activate/{code}")
    public String activationUser(Model model, @PathVariable String code) {
        boolean isActivated = userService.activationUser(code);

        if (isActivated) {
            model.addAttribute("message", "User successfully activated!");
        }else {
            model.addAttribute("message", "Activation code not found!");
        }
        return "login";
    }

}
