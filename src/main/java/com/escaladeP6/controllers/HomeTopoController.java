package com.escaladeP6.controllers;


import com.escaladeP6.DAO.CommentaireRepository;
import com.escaladeP6.DAO.EmpruntTopoRepository;
import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Commentaire;
import com.escaladeP6.beans.EmpruntTopo;
import com.escaladeP6.beans.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeTopoController {

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    CommentaireRepository commentaireRepository;

    @Autowired
    EmpruntTopoRepository empruntTopoRepository;

    @RequestMapping(value="/topoHome", method = RequestMethod.GET)
    public String topoHome(Model model, Principal principal){


        User loginedUser = (User) ((Authentication) principal).getPrincipal();


        int nbTopoTotal = (int) topoRepository.count();
        int nbMembres = (int) membreRepository.count();
        int nbTopoEmpruntes = (topoRepository.nbToposDispo().size());
        String nomDernierTopoPublie;
        String pseudo = loginedUser.getUsername();
        Membre membre = membreRepository.findMembreByPseudo(pseudo);

        List<EmpruntTopo> empruntList = empruntTopoRepository.findEmpruntToposByMembreAndEnCoursIsTrue(membre);

        List<Commentaire> commentaireList = commentaireRepository.findCommentairesByMembreOrderByDateDesc(membre);


        try {nomDernierTopoPublie = String.valueOf(topoRepository.listeToposParId().get(0).getNom());}
        catch (Exception e){
            nomDernierTopoPublie = null;
        }

        model.addAttribute("nbTopoTotal", nbTopoTotal );
        model.addAttribute("nbTopoEmpruntes", nbTopoEmpruntes);
        model.addAttribute("nomDernierTopoPublie", nomDernierTopoPublie);
        model.addAttribute("membre", membre);
        model.addAttribute("nbMembre", nbMembres);
        model.addAttribute("commentaireList", commentaireList);
        model.addAttribute("empruntList", empruntList);
        return "topoHome";

    }



}
