package com.escaladeP6.controllers;

import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




import java.security.Principal;

@Controller
public class GererTopoController {

     @Autowired
    TopoRepository topoRepository;

     @Autowired
    MembreRepository repository;

    @RequestMapping(value="/topoGerer", method = RequestMethod.GET)
    public String publicationForm(Model model, Principal principal){



        //identification du membre : recherche de son membreId
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String pseudo = loginedUser.getUsername();
        int idMembre = repository.findMembreByPseudo(pseudo).getId();


//        requete des topos de l'utilisateur
        model.addAttribute("mesTopos", topoRepository.findToposByMembreId(idMembre));

               return "topoGerer";

    }











    }



