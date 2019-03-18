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

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);




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
