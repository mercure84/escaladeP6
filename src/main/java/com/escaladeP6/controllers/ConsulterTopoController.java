package com.escaladeP6.controllers;


import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Departement;
import com.escaladeP6.beans.Filtre;
import com.escaladeP6.beans.Topo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
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

@RequestMapping("/topoConsulter/fichiers")
public @ResponseBody String dlFichier(String topoId) throws SQLException, IOException {

    System.out.println("topoid vaut " + topoId + " c'est un "+ topoId.getClass().getName());

    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/escap6", "postgres", "chatons2019");
    PreparedStatement ps = conn.prepareStatement("SELECT topo.fichier FROM topo WHERE id=?");
    ps.setInt(1, Integer.parseInt(topoId));
    ResultSet rs = ps.executeQuery();
    String localPath = System.getProperty("user.dir");
    String path = "fichiers/topo"+topoId+".pdf";

    if (rs != null) {
        while (rs.next()) {
            byte[] fichier = rs.getBytes("fichier");

            File file=new File(path);
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(fichier);
            fos.close();

        }
        rs.close();
    }
    ps.close();


    return "<a href='"+localPath+"/"+path+"'>TELECHARGER</a>";
}
}

