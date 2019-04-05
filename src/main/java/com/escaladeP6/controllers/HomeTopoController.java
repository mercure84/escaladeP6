package com.escaladeP6.controllers;


import com.escaladeP6.DAO.CommentaireRepository;
import com.escaladeP6.DAO.EmpruntTopoRepository;
import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Commentaire;
import com.escaladeP6.beans.EmpruntTopo;
import com.escaladeP6.beans.Membre;
import com.escaladeP6.beans.Topo;
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
        String pseudo = loginedUser.getUsername();
        Membre membre = membreRepository.findMembreByPseudo(pseudo);

        //données du membre

        List<Topo> listeToposMembre = topoRepository.findToposByMembre(membre);



        List<EmpruntTopo> empruntList = empruntTopoRepository.findEmpruntToposByMembreAndEnCoursIsTrue(membre);

        List<Commentaire> commentaireList = commentaireRepository.findCommentairesByMembreOrderByDateDesc(membre);


        model.addAttribute("nbTopo", listeToposMembre.size() );
        model.addAttribute("nbTopoEmpruntes", empruntList.size());

        model.addAttribute("membre", membre);

        model.addAttribute("commentaireList", commentaireList);
        model.addAttribute("empruntList", empruntList);
        return "topoHome";

    }



}
