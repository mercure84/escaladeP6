package com.escaladeP6.controllers;

import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Departement;
import com.escaladeP6.beans.Topo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PublierTopoController {

    @Autowired
    TopoRepository repository;

    @RequestMapping("/topoPublier")
    public String publicationForm(Model model){

        ArrayList<Integer> listeNumDpt = new ArrayList<Integer>();
        for (Departement dept : Departement.values()){
            listeNumDpt.add(dept.getNumDpt());
        }

        model.addAttribute("topo", new Topo());
        model.addAttribute("listeDept",listeNumDpt);
        return "topoPublier";
    }

    @PostMapping("/topoPublier")
    public String publicationSubmit (@ModelAttribute Topo topo){

        System.out.println("les données du formulaires ont été sauvées");
        repository.save(new Topo(topo.getNom(), topo.getDescription(), topo.getDepartement(), topo.getDifficulte(), topo.isDisponible(), topo.isValide(), 1));

        return "index";
    }


}
