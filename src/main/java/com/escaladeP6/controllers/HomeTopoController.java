package com.escaladeP6.controllers;


import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeTopoController {

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    MembreRepository membreRepository;




    @GetMapping("/topoHome")
    public String topoHome(Model model){
        int nbTopoTotal = (int) topoRepository.count();
        int nbMembres = (int) membreRepository.count();
        int nbTopoEmpruntés = 20;
        String nomDernierTopoPublie = "Acropora des chatons";
        String pseudoMembre = "Mjuju92130";
        model.addAttribute("nbTopoTotal", nbTopoTotal );
        model.addAttribute("nbTopoEmpruntes", nbTopoEmpruntés);
        model.addAttribute("nomDernierTopoPublie", nomDernierTopoPublie);
        model.addAttribute("pseudoMembre", pseudoMembre);
        model.addAttribute("nbMembre", nbMembres);
        return "topoHome";

    }



}