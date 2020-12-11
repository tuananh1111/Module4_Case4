package com.casestudy.case4.controller;

import com.casestudy.case4.model.Province;
import com.casestudy.case4.model.Role;
import com.casestudy.case4.model.User;
import com.casestudy.case4.service.role.IRoleService;
import com.casestudy.case4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
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

    @ModelAttribute("roles")
    public Iterable<Role> listRole() {
        return iRoleService.findAll();
    }

    @GetMapping("/list-user")
    public ModelAndView listUser(){
        ModelAndView modelAndView= new ModelAndView("admin/listUser");
        Iterable<User> users= iUserService.findAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<User> user= iUserService.findById(id);
        ModelAndView modelAndView= new ModelAndView("user/edit");
        modelAndView.addObject("user", user.get());
        return modelAndView;
    }
    @PostMapping("/edit-user")
    public ModelAndView updateUser(@ModelAttribute User user){
        iUserService.save(user);
        ModelAndView modelAndView= new ModelAndView("user/edit");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "Updated USER successful!!!");
        return modelAndView;
    }

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
