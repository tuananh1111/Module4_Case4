package com.casestudy.case4.controller;

import com.casestudy.case4.model.Role;
import com.casestudy.case4.model.User;
import com.casestudy.case4.model.UserPrinciple;
import com.casestudy.case4.service.role.IRoleService;
import com.casestudy.case4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private User getPrincipal(){
        User userCurrent = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPrinciple userPrinciple = (UserPrinciple) principal;
         userCurrent = iUserService.findByUserName(userPrinciple.getUsername());
         return userCurrent;
    }

    @ModelAttribute("listRole")
    public Iterable<Role> listRole() {
        return iRoleService.findAll();
    }

    @GetMapping("/list-user")
    public ModelAndView listUser(){

        ModelAndView modelAndView= new ModelAndView("admin/listUser");
        Iterable<User> users= iUserService.findAll();
        modelAndView.addObject("users", users);
        modelAndView.addObject("userCurrent", getPrincipal());
        return modelAndView;
    }

//    @PostMapping("/edit-user")
//    public ModelAndView updateUser(@ModelAttribute User user){
//        iUserService.save(user);
//        ModelAndView modelAndView= new ModelAndView("user/edit");
//        modelAndView.addObject("user", new User());
//        modelAndView.addObject("message", "Updated USER successful!!!");
//        return modelAndView;
//    }

    @GetMapping("/create-user")
    public ModelAndView showListForm() {
        ModelAndView modelAndView = new ModelAndView("user/CreateUserTh");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("user/CreateUserTh");
        if (!bindingResult.hasFieldErrors()) {
            if (user.getRoles()== null){
                Role role = iRoleService.findRoleByName("ROLE_USER");
                Set<Role> roles = new HashSet<>();
                roles.add(role);
                user.setRoles(roles);
            }
            user.setPassWord(passwordEncoder.encode(user.getPassWord()));
            iUserService.save(user);
            modelAndView.addObject("user", user);
            modelAndView.addObject("message", "New user created successfully");
        }
        return modelAndView;
    }

}
