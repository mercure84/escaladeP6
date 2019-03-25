package com.escaladeP6.controllers;


import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.security.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeTopoController {

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    MembreRepository membreRepository;

    @RequestMapping(value="/topoHome", method = RequestMethod.GET)
    public String topoHome(Model model, Principal principal){


        User loginedUser = (User) ((Authentication) principal).getPrincipal();


        int nbTopoTotal = (int) topoRepository.count();
        int nbMembres = (int) membreRepository.count();
        int nbTopoEmpruntes = (topoRepository.nbToposDispo().size());
        String nomDernierTopoPublie = null;
        try {nomDernierTopoPublie = String.valueOf(topoRepository.listeToposParId().get(0).getNom());}
        catch (Exception e){
            nomDernierTopoPublie = null;
        }
        String pseudo = loginedUser.getUsername();
        String titreMembre = membreRepository.findMembreByPseudo(pseudo).getPrenom() + " " + membreRepository.findMembreByPseudo(pseudo).getNom();

        model.addAttribute("nbTopoTotal", nbTopoTotal );
        model.addAttribute("nbTopoEmpruntes", nbTopoEmpruntes);
        model.addAttribute("nomDernierTopoPublie", nomDernierTopoPublie);
        model.addAttribute("titreMembre", titreMembre);
        model.addAttribute("nbMembre", nbMembres);
        return "topoHome";

    }



}
