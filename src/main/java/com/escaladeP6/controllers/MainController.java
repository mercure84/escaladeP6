package com.escaladeP6.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class MainController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index (Model model){

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userInfo(Model model) {
        return "login";
    }




}
