package com.escaladeP6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

    @GetMapping("/signUp")
    public String index (Model model){
        return "signUp";
    }

}
