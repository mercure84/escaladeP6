package com.escaladeP6.controllers;


import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.DAO.VoieRepository;
import com.escaladeP6.beans.Departement;
import com.escaladeP6.beans.Membre;
import com.escaladeP6.beans.Topo;
import com.escaladeP6.beans.Voie;
import com.escaladeP6.security.UserDetailsServiceImpl;
import com.escaladeP6.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class EditerTopoController {

    private final StorageService storageService;

    private static final Logger logger = LoggerFactory.getLogger(EditerTopoController.class);


    @Autowired
    public EditerTopoController(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    VoieRepository voieRepository;

    @RequestMapping(value="/topoEditer", method = RequestMethod.GET)
    public String editerTopo(String topoId, Model model, Principal principal){

        //identification du membre : recherche de son membreId
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String pseudo = loginedUser.getUsername();
        int idMembre = membreRepository.findMembreByPseudo(pseudo).getId();

        //départements
        ArrayList<Integer> listeNumDpt = new ArrayList<Integer>();
        for (Departement dept : Departement.values()){
            listeNumDpt.add(dept.getNumDpt());
        }
        model.addAttribute("listeDept",listeNumDpt);


        //recherche du Topo à éditer si le membre à cliquer sur Editer
        String creer = "creer";


        if (!topoId.equals(creer)){
        Topo editedTopo = topoRepository.findTopoById(Integer.parseInt(topoId));
        model.addAttribute("topo", editedTopo);
        model.addAttribute("idEdited", editedTopo.getId());
        model.addAttribute("voie", new Voie());
        model.addAttribute("listeVoies", voieRepository.findVoiesByTopo(editedTopo));

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
        int idMembre = membreRepository.findMembreByPseudo(pseudo).getId();
        Membre membreEditeur = membreRepository.findMembreById(idMembre);

     //enregistrer du topo dans la base
//        System.out.println("l'id du topo est : + " + topo.getId());


        //si on a un id différent de 0, on update sinon on insert
        if (topo.getId() != 0){
            try (PreparedStatement us = conn.prepareStatement("UPDATE topo SET nom=?, description=?, departement=?, nb_voies=?, difficulte=? WHERE id=?")) {
                us.setString(1, topo.getNom());
                us.setString(2, topo.getDescription());
                us.setInt(3, topo.getDepartement());
                us.setInt(4, topo.getNbVoies());
                us.setString(5, topo.getDifficulte());
                us.setInt(6, topo.getId());
                us.executeUpdate();
                logger.info("Mise à jour du Topo n° " + topo.getId() + " par le membre " + membreEditeur.getPseudo());
            }   catch (Exception e) {
            e.printStackTrace();
        }
        }

        else {

            topoRepository.save(new Topo(topo.getNom(), topo.getDescription(), topo.getDepartement(), topo.getDifficulte(), topo.getNbVoies(), topo.isDisponible(), topo.isValide(), membreEditeur));
            logger.info("Création d'un nouveau topo nommé " + topo.getNom() + " par le membre " + membreEditeur.getPseudo());

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

    @PostMapping("/voieAjouter")
    public String ajouterVoie(@ModelAttribute Voie voie, Principal principal, String topoId){

        Topo topo = topoRepository.findTopoById(Integer.parseInt(topoId));
        voie.setTopo(topo);
        voieRepository.save(voie);
        logger.info(" le topo " + topo.getNom() + " a été enrichie d'une voie");

        return "redirect:topoEditer?topoId="+voie.getTopo().getId();

    }







}
