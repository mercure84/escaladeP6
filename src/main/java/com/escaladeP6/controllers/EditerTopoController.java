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

import javax.servlet.http.HttpServletRequest;
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
public class EditerTopoController {

    private final StorageService storageService;

    @Autowired
    public EditerTopoController(StorageService storageService) {
        this.storageService = storageService;
    }

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

        //départements
        ArrayList<Integer> listeNumDpt = new ArrayList<Integer>();
        for (Departement dept : Departement.values()){
            listeNumDpt.add(dept.getNumDpt());
        }
        model.addAttribute("listeDept",listeNumDpt);


        //recherche du Topo à éditer si le membre à cliquer sur Editer
        String creer = "creer";


        if (!topoId.equals(creer)){
        Topo editedTopo = repositoryTopo.findTopoById(Integer.parseInt(topoId));
        model.addAttribute("topo", editedTopo);
        model.addAttribute("idEdited", editedTopo.getId());
        System.out.println(editedTopo);
        }else
            {
            //sinon on envoie un objet nouveau topo :)
            model.addAttribute("topo", new Topo());


        }

        return "topoEditer";
    }

    @PostMapping("/topoEditer")
    public String publicationSubmit (@RequestParam("file") MultipartFile file, @ModelAttribute Topo topo, Principal principal) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/escap6", "postgres", "dionae1984");

        // SELECTION DU MEMBRE QUI POSTE LE TOPO
        //chargement des paramètres du membres
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String pseudo = loginedUser.getUsername();
        int idMembre = repositoryMembre.findMembreByPseudo(pseudo).getId();
        Membre membreEditeur = repositoryMembre.findMembreById(idMembre);

        //enregistrer du topo dans la base
        System.out.println("l'id du topo est : + " + topo.getId());


        //si on a un id différent de 0, on update sinon on insert
        if (topo.getId() != 0){
            try (PreparedStatement us = conn.prepareStatement("UPDATE topo SET nom=?, description=?, departement=?, nb_voies=? WHERE id=?")) {
                us.setString(1, topo.getNom());
                us.setString(2, topo.getDescription());
                us.setInt(3, topo.getDepartement());
                us.setInt(4, topo.getNbVoies());
                us.setInt(5, topo.getId());
                us.executeUpdate();


            }   catch (Exception e) {
            e.printStackTrace();
        }



        }

        else {

            repositoryTopo.save(new Topo(topo.getNom(), topo.getDescription(), topo.getDepartement(), topo.getDifficulte(), topo.getNbVoies(), topo.isDisponible(), topo.isValide(), membreEditeur));
        }

        // TRAITEMENT DU STOCKAGE DU FICHIER SI L'UTILISATEUR PROPOSE UN UPLOAD
        if(!file.isEmpty()){

        String nomInitialFichier = file.getOriginalFilename();
        storageService.store((file));


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
        }}

        return "redirect:topoGerer";
    }
}
