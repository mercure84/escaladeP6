package com.escaladeP6.controllers;

import com.escaladeP6.beans.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @GetMapping("/signUp")
    public String senregistrerForm (Model model){
        model.addAttribute("membre", new Membre());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String senregistrerSubmit(@ModelAttribute Membre membre){

        System.out.println("les données du formulaires :");
        System.out.println(membre.getNom() + " " + membre.getPrenom() + " " + membre.getPseudo());

        return "index";

    }

}
