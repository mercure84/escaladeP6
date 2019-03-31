package com.escaladeP6.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;


@Controller
public class MainController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index (Model model, Principal principal){

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage (Model model, Principal principal ) {
        return "loginPage";
    }



    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String error(Model model, Principal principal){


        return "error";

    }



}
