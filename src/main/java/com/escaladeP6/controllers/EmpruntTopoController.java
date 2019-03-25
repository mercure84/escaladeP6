package com.escaladeP6.controllers;

import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.EmpruntTopo;
import com.escaladeP6.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class EmpruntTopoController {

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    MembreRepository membreRepository;




    @RequestMapping(value="/topoEmprunter", method = RequestMethod.GET)
    public String emprunterTopo(Model model, Principal principal, String topoId){
        EmpruntTopo empruntTopo = new EmpruntTopo();

        //recherche du topo concerné :
        Topo topoCible = topoRepository.findTopoById(Integer.parseInt(topoId));


        model.addAttribute("empruntTopo", empruntTopo);
        model.addAttribute("topo", topoCible);


           return "topoEmprunter";

    }






}
