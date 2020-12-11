package com.casestudy.case4.controller;

import com.casestudy.case4.model.User;
import com.casestudy.case4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private IUserService IUserService;

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("user",new User());
        return "index";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "access-denied";
    }
}
