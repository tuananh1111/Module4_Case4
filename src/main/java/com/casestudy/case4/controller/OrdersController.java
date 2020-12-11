package com.casestudy.case4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class OrdersController {
    @GetMapping("/list-orders")
    public ModelAndView listOrders(){
        ModelAndView modelAndView = new ModelAndView("orders/list");
        return  modelAndView;
    }
}
