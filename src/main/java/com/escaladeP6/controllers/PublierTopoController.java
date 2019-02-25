package com.escaladeP6.controllers;

import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Topo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublierTopoController {

    @Autowired
    TopoRepository repository;

    @RequestMapping("/topoPublier")
    public String publicationForm(Model model){
        model.addAttribute("topo", new Topo());
        return "topoPublier";
    }

    @PostMapping("/topoPublier")
    public String publicationSubmit (@ModelAttribute Topo topo){
        System.out.println("les données du formulaires ont été sauvées");
        repository.save(new Topo(topo.getNom(), topo.getDescription(), topo.getDifficulte(), topo.isDisponible(), topo.isValide(), 1));

        return "index";
    }


}
