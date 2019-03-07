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
        int nbTopoEmpruntes = (topoRepository.nbToposDispo().size());
        String nomDernierTopoPublie = null;
        try {nomDernierTopoPublie = String.valueOf(topoRepository.listeToposParId().get(0).getNom());}
        catch (Exception e){
            nomDernierTopoPublie = null;
        }

        String pseudoMembre = "Mjuju92130";
        model.addAttribute("nbTopoTotal", nbTopoTotal );
        model.addAttribute("nbTopoEmpruntes", nbTopoEmpruntes);
        model.addAttribute("nomDernierTopoPublie", nomDernierTopoPublie);
        model.addAttribute("pseudoMembre", pseudoMembre);
        model.addAttribute("nbMembre", nbMembres);
        return "topoHome";

    }



}
