package com.escaladeP6.controllers;

import com.escaladeP6.DAO.CommentaireRepository;
import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Commentaire;
import com.escaladeP6.beans.Membre;
import com.escaladeP6.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.sql.SQLException;

@Controller
public class CommentaireController {

    @Autowired
    TopoRepository repositoryTopo;

    @Autowired
    MembreRepository repositoryMembre;

    @Autowired
    CommentaireRepository repositoryCommentaire;


    @PostMapping("/posterMessage")
    public String posterCommentaire(@ModelAttribute Commentaire commentaire, Principal principal, String topoId){


        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String pseudo = loginedUser.getUsername();



        System.out.println("Topo commenté = " + Integer.parseInt(topoId));

        Topo topo = repositoryTopo.findTopoById(Integer.parseInt(topoId));

        Membre membre = repositoryMembre.findMembreByPseudo(pseudo);
        commentaire.setMembre(membre);
        commentaire.setTopo(topo);
        repositoryCommentaire.save(commentaire);

        return "redirect:topoDetails?topoId="+topoId;

    }


}
