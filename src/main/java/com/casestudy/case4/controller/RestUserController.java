//package com.casestudy.case4.controller;
//
//import com.casestudy.case4.model.Role;
//import com.casestudy.case4.model.User;
//import com.casestudy.case4.service.role.RoleService;
//import com.casestudy.case4.service.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//@RestController
//public class RestUserController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @RequestMapping(value = "api/createNewUser", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> createCustomer(@RequestBody User user) {
//        userService.save(user);
//        return new ResponseEntity<Void>(HttpStatus.CREATED);
//    }
//    @RequestMapping(value = "api/hello", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> getHello() {
//        Role role = roleService.findRoleByName("ROLE_USER");
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        userService.save(new User((long)6, "NAL", "123", "123", 19, "123@gmail.com", "admin", "123", true, roles));
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }
//
//}
