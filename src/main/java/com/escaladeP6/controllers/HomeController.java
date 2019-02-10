package com.escaladeP6.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model){
        int nbTopoTotal = 84;
        int nbTopoEmpruntés = 20;
        String nomDernierTopoPublie = "L'arbre à chats";
        String pseudoMembre = "Mjuju92130";

        model.addAttribute("nbTopoTotal", nbTopoTotal);
        model.addAttribute("nbTopoEmpruntes", nbTopoEmpruntés);
        model.addAttribute("nomDernierTopoPublie", nomDernierTopoPublie);
        model.addAttribute("pseudoMembre", pseudoMembre);

        return "home";

    }



}
