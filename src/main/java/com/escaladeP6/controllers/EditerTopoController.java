package com.escaladeP6.controllers;


import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class EditerTopoController {

    @Autowired
    TopoRepository repositoryTopo;

    @Autowired
    MembreRepository repositoryMembre;



    @RequestMapping(value="/topoEditer", method = RequestMethod.GET)
    public String editerTopo(String topoId, Model model, Principal principal){

        //identification du membre : recherche de son membreId
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String pseudo = loginedUser.getUsername();
        int idMembre = repositoryMembre.findMembreByPseudo(pseudo).getId();


        //recherche du Topo à éditer !
        Topo editedTopo = repositoryTopo.findTopoById(Integer.parseInt(topoId));

        model.addAttribute("editedTopo", editedTopo);
        System.out.println(editedTopo);

        return "topoEditer";
    }


}
