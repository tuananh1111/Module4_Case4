package com.casestudy.case4.controller;

import com.casestudy.case4.model.Role;
import com.casestudy.case4.model.User;
import com.casestudy.case4.service.role.IRoleService;
import com.casestudy.case4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Password;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //    @RequestMapping(value = "/createNewUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public User createUserName(@RequestBody User user) {
//        Role role = roleService.findRoleByName("ROLE_USER");
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        user.setRoles(roles);
//        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
//        return userService.save(user);
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
            Role role = iRoleService.findRoleByName("ROLE_USER");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            user.setPassWord(passwordEncoder.encode(user.getPassWord()));
            iUserService.save(user);
            modelAndView.addObject("user", user);
            modelAndView.addObject("message", "New user created successfully");
        }
        return modelAndView;
    }
    @GetMapping("/user/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<User> user= iUserService.findById(id);
        ModelAndView modelAndView= new ModelAndView("user/edit");
        modelAndView.addObject("user", user.get());
        return modelAndView;
    }
    @PostMapping("/user/edit-user")
    public ModelAndView updateUser(@RequestParam String password, @ModelAttribute User user){
        user.setPassWord(passwordEncoder.encode(password));
        iUserService.save(user);
        ModelAndView modelAndView= new ModelAndView("user/edit");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "Updated USER successful!!!");
        return modelAndView;
    }
//    @GetMapping("/user/delete-user/{id}")
//    public ModelAndView deleteUser(@PathVariable Long id){
//        iUserService.remove(id);
//        Iterable<User> list= iUserService.findAll();
//        ModelAndView modelAndView= new ModelAndView("user/home");
//        modelAndView.addObject("list", list);
//        return modelAndView;
//    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<User> allBook() {
        return iUserService.findAll();
    }

}
