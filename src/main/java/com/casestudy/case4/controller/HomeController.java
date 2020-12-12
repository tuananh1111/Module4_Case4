package com.casestudy.case4.controller;

import com.casestudy.case4.model.Hotel;
import com.casestudy.case4.model.User;
import com.casestudy.case4.model.UserPrinciple;
import com.casestudy.case4.service.hotel.IHotelService;
import com.casestudy.case4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IHotelService iHotelService;

    private User getPrincipal(){
        User userCurrent = null;
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPrinciple userPrinciple = (UserPrinciple) principal;
        userCurrent = iUserService.findByUserName(userPrinciple.getUsername());
        return userCurrent;
    }

    @GetMapping("/user")
    public String userPage(Model model) {
        model.addAttribute("userCurrent", getPrincipal());
        return "user";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("userCurrent", getPrincipal());
        return "admin";
    }

    @GetMapping("/")
    public String homePage(Model model, Pageable pageable) {
        model.addAttribute("user",new User());
        return "index";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "access-denied";
    }
}
