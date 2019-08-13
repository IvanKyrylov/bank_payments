package com.cursach.controller;

import com.cursach.entity.BankAccount;
import com.cursach.entity.User;
import com.cursach.service.BankAccountService;
import com.cursach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

   @Autowired
   private BankAccountService bankAccountService;

   @Autowired
   private UserService userService;

    @GetMapping("/users")
    public String allAccount(Model model, Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());

        model.addAttribute("accountList", bankAccountService.findBankAccountByUserId(user.getId()));
        return "user";
    }

    @PostMapping("/add")
    public String addAccount(BankAccount bankAccount, Principal principal) {
        bankAccount.setUserId((User) userService.loadUserByUsername(principal.getName()));
        bankAccountService.addBankAccount(bankAccount);
        return "redirect:/users";
    }

    @GetMapping("/take/{id}")
    public String takeCash(@PathVariable int id) {
        return "edit";
    }

    @GetMapping("/repay/{id}")
    public String repayCash(@PathVariable int id) {
        return "edit";
    }
}
