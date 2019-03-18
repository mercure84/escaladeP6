package com.escaladeP6.controllers;

import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.RoleMembreRepository;
import com.escaladeP6.beans.Membre;

import com.escaladeP6.beans.RoleMembre;
import com.escaladeP6.security.EncryptedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    MembreRepository repository;

    @Autowired
    RoleMembreRepository roleMembreRepository;

    @RequestMapping("/signUp")
    public String senregistrerForm (Model model){
        model.addAttribute("membre", new Membre());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String senregistrerSubmit(@ModelAttribute Membre membre){
        System.out.println("les données du formulaires ont été sauvegardées");
        System.out.println(membre.getNom() + " " + membre.getPrenom() + " " + membre.getPseudo() + " " + membre.getPseudo() + membre.getPassword());
        String encodedPassword = EncryptedPasswordUtils.encryptePassword(membre.getPassword());
        //création du membre :
        Membre nouveauMembre = new Membre(membre.getNom(), membre.getPrenom(), membre.getPseudo(), encodedPassword, membre.getEmail());

        //sauvegarde du membre dans la table des membres
        repository.save(nouveauMembre);

        //attribution d'un rôle au membre nouvellement créé
        roleMembreRepository.save(new RoleMembre(nouveauMembre, 1));


        return "index";


    }


}
