package com.escaladeP6.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeTopoController {

    @GetMapping("/topoHome")
    public String topoHome(Model model){
        int nbTopoTotal = 84;
        int nbTopoEmpruntés = 20;
        String nomDernierTopoPublie = "Acropora des chatons";
        String pseudoMembre = "Mjuju92130";
        model.addAttribute("nbTopoTotal", nbTopoTotal);
        model.addAttribute("nbTopoEmpruntes", nbTopoEmpruntés);
        model.addAttribute("nomDernierTopoPublie", nomDernierTopoPublie);
        model.addAttribute("pseudoMembre", pseudoMembre);
        return "topoHome";

    }



}
