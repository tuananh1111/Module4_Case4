package com.casestudy.case4.controller;

import com.casestudy.case4.model.Comment;
import com.casestudy.case4.model.Hotel;
import com.casestudy.case4.model.User;
import com.casestudy.case4.model.UserPrinciple;
import com.casestudy.case4.service.comment.ICommentService;
import com.casestudy.case4.service.hotel.IHotelService;
import com.casestudy.case4.service.role.IRoleService;
import com.casestudy.case4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ICommentService iCommentService;
    @Autowired
    private IHotelService iHotelService;
//    @ModelAttribute("userCurrent")
//    private User getPrincipal(){
//        User userCurrent = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        userCurrent = iUserService.findByUserName(((UserDetails)principal).getUsername());
//        return userCurrent;
//    }

    @RequestMapping(value = "/create-comment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Comment deleteSmartphone(@RequestBody Comment comment){
//        Hotel hotel= iHotelService.findAllById(1L);
//        comment.setHotel(hotel);
//        User user = iUserService.findByUserName("lien");
//        comment.setUser(user);
        return iCommentService.save(comment);
    }
    @GetMapping("/list-comment")
    public Iterable<Comment> comments(){
        return iCommentService.findAll();
    }
    @RequestMapping(value = "/listComment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Comment> allComment(){
        return iCommentService.findAll();
    }

}
