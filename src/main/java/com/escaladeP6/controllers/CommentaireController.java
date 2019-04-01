package com.escaladeP6.controllers;

import com.escaladeP6.DAO.CommentaireRepository;
import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Commentaire;
import com.escaladeP6.beans.Membre;
import com.escaladeP6.beans.Topo;
import com.escaladeP6.security.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;


@Controller
public class CommentaireController {

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    CommentaireRepository commentaireRepository;

    private static final Logger logger = LoggerFactory.getLogger(CommentaireController.class);


    @PostMapping("/posterMessage")
    public String posterCommentaire(@ModelAttribute Commentaire commentaire, Principal principal, String topoId){


        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String pseudo = loginedUser.getUsername();

        Topo topo = topoRepository.findTopoById(Integer.parseInt(topoId));

        Membre membre = membreRepository.findMembreByPseudo(pseudo);
        commentaire.setMembre(membre);
        commentaire.setTopo(topo);

        Date date = new Date();
        commentaire.setDate(new Timestamp(date.getTime()));
        commentaireRepository.save(commentaire);

        logger.info("Un commentaire vient d'être publié par " + membre.getPseudo() + " pour le Topo : " + topo.getNom());

        return "redirect:topoDetails?topoId="+topoId;

    }


}
