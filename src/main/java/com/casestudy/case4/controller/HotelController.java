package com.casestudy.case4.controller;

import com.casestudy.case4.model.Hotel;
import com.casestudy.case4.model.Province;
import com.casestudy.case4.model.User;
import com.casestudy.case4.service.hotel.IHotelService;
import com.casestudy.case4.service.province.IProvinceService;
import com.casestudy.case4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private IUserService userService;

    @ModelAttribute("users")
    public Iterable<User> users(){
        return userService.findAll();
    }
    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/admin/list-hotel")
    public ModelAndView hotelList(Pageable pageable){
        Page<Hotel> list= hotelService.findAllByStatusIsFalse(pageable);
        ModelAndView modelAndView= new ModelAndView("hotel/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/admin/create-hotel")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView= new ModelAndView("hotel/create");
        modelAndView.addObject("hotel", new Hotel());
        return modelAndView;
    }
    @PostMapping("/admin/create-hotel")
    public ModelAndView saveHotel(@ModelAttribute Hotel hotel){
        hotelService.save(hotel);
        ModelAndView modelAndView= new ModelAndView("hotel/create");
        modelAndView.addObject("hotel", new Hotel());
        modelAndView.addObject("message","Save Hotel Successful!!!");
        return modelAndView;
    }
    @GetMapping("/admin/edit-hotel/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Optional<Hotel> hotel=hotelService.findById(id);
        ModelAndView modelAndView= new ModelAndView("hotel/edit");
        modelAndView.addObject("hotel",hotel.get());
        return modelAndView;
    }
    @PostMapping("/admin/edit-hotel")
    public ModelAndView updateHotel(@ModelAttribute Hotel hotel){
        hotelService.save(hotel);
        ModelAndView modelAndView= new ModelAndView("hotel/edit");
        modelAndView.addObject("hotel",new Hotel());
        modelAndView.addObject("message","Update Hotel Successfully!!!");
        return modelAndView;
    }
    @GetMapping("/admin/delete-hotel/{id}")
    public ModelAndView disable(@PathVariable Long id, Pageable pageable){
        Page<Hotel> hotels = hotelService.findAllByStatusIsFalse(pageable);
        hotelService.remove(id);
        ModelAndView modelAndView= new ModelAndView("hotel/list");
        modelAndView.addObject("list",hotels);
        return modelAndView;
    }
}
