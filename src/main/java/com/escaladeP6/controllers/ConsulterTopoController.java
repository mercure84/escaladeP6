package com.escaladeP6.controllers;


import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Departement;
import com.escaladeP6.beans.Filtre;
import com.escaladeP6.beans.Topo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ConsulterTopoController {

    @Autowired
    TopoRepository repository;


@RequestMapping("/topoConsulter")
public String topos (Model model){
    // liste des département générée depuis l'enum
    ArrayList<Integer> listeNumDpt = new ArrayList<Integer>();
    for (Departement dept : Departement.values()){
        listeNumDpt.add(dept.getNumDpt());

    }

    List<Topo> testTopos = repository.findAll();
    byte[] fichier = testTopos.get(0).getFichier();
    System.out.println("Le fichier est : " + testTopos.get(0).getFichier());




        model.addAttribute("topos", repository.findAll());
        model.addAttribute("listeDept", listeNumDpt);
        model.addAttribute("filtre", new Filtre());

        return "topoConsulter";
}

@PostMapping("/topoConsulter")
    public String topoSearch(@ModelAttribute Filtre filtre, Model model){
    // liste des département générée depuis l'enum
    ArrayList<Integer> listeNumDpt = new ArrayList<Integer>();
    for (Departement dept : Departement.values()){
        listeNumDpt.add(dept.getNumDpt());
    }


    model.addAttribute("listeDept", listeNumDpt);
    System.out.println("les valeurs demandées par le filtre sont les suivantes :");
    System.out.println("dpt = " + filtre.getDepartement() + " difficulte = " + filtre.getDifficulte() + " nb voie = " + filtre.getNbVoies() + " dispo : " + filtre.isDisponible());

    model.addAttribute("topos", repository.filtrerTopos(filtre.getDepartement(), filtre.getDifficulte(), filtre.isDisponible()));
    return "topoConsulter";



}


}
