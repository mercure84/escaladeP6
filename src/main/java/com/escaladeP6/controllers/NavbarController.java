package com.escaladeP6.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class NavbarController {

    @RequestMapping(value="navbar", method = RequestMethod.GET)
    public String afficherNavbar(Principal principal, Model model){

        model.addAttribute("user", principal.getName());


        return "navbar";
    }





}
