package com.escaladeP6.controllers;

import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.beans.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    MembreRepository repository;

    @RequestMapping("/signUp")
    public String senregistrerForm (Model model){
        model.addAttribute("membre", new Membre());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String senregistrerSubmit(@ModelAttribute Membre membre){

        System.out.println("les données du formulaires :");
        System.out.println(membre.getNom() + " " + membre.getPrenom() + " " + membre.getPseudo() + " " + membre.getPseudo() + membre.getPassword());
        repository.save(new Membre(membre.getNom(), membre.getPrenom(), membre.getPseudo(), membre.getPassword(), membre.getEmail()));
        return "index";

    }


}
