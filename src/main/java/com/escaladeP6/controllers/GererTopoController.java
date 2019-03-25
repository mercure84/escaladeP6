package com.escaladeP6.controllers;

import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Departement;
import com.escaladeP6.beans.Membre;
import com.escaladeP6.beans.Topo;

import com.escaladeP6.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class GererTopoController {

    private final StorageService storageService;

    @Autowired
    public GererTopoController(StorageService storageService) {
        this.storageService = storageService;
    }

     @Autowired
    TopoRepository repositoryTopo;

     @Autowired
    MembreRepository repositoryMembre;

    @RequestMapping(value="/topoGerer", method = RequestMethod.GET)
    public String publicationForm(Model model, Principal principal){



        //identification du membre : recherche de son membreId
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String pseudo = loginedUser.getUsername();
        int idMembre = repositoryMembre.findMembreByPseudo(pseudo).getId();

        ArrayList<Integer> listeNumDpt = new ArrayList<Integer>();
        for (Departement dept : Departement.values()){
            listeNumDpt.add(dept.getNumDpt());
        }
        model.addAttribute("topo", new Topo());
        model.addAttribute("listeDept",listeNumDpt);

//        requete des topos de l'utilisateur
        model.addAttribute("mesTopos", repositoryTopo.findToposByMembreId(idMembre));

               return "topoGerer";

    }

    @PostMapping("/topoGerer")
    public String publicationSubmit (@RequestParam("file") MultipartFile file, @ModelAttribute Topo topo, Principal principal, Model model) throws SQLException {
        // SELECTION DU MEMBRE QUI POSTE LE TOPO



        //chargement des paramètres du membres
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String pseudo = loginedUser.getUsername();
        int idMembre = repositoryMembre.findMembreByPseudo(pseudo).getId();
        Membre membreEditeur = repositoryMembre.findMembreById(idMembre);

        //        requete des topos de l'utilisateur
        model.addAttribute("mesTopos", repositoryTopo.findToposByMembreId(idMembre));


        repositoryTopo.save(new Topo(topo.getNom(), topo.getDescription(), topo.getDepartement(), topo.getDifficulte(), topo.getNbVoies(), topo.isDisponible(), topo.isValide(), membreEditeur));


    // TRAITEMENT DU STOCKAGE DU FICHIER
        String nomInitialFichier = file.getOriginalFilename();
        storageService.store((file));
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/escap6", "postgres", "dionae1984");

        try (PreparedStatement ps = conn.prepareStatement("UPDATE topo SET nom_fichier=?, fichier=? WHERE nom=?")) {


            //traitement du fichier
            System.out.println("le nom du fichier est : " + nomInitialFichier);
            File fileTopo = new File("fichiers/" + nomInitialFichier);
            try {
                FileInputStream fis = new FileInputStream(fileTopo);
                ps.setString(1, topo.getNom());
                ps.setBinaryStream(2, fis, fileTopo.length());
                ps.setString(3, topo.getNom());
                ps.executeUpdate();
                ps.close();
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "/topoGerer";
    }









    }



