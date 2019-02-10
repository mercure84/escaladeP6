package com.escaladeP6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AccueilController {

    @GetMapping("/")

    public String accueil(Model model){
        return "index";
    }


}
