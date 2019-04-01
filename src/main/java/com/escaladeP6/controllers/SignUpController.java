package com.escaladeP6.controllers;

import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.RoleMembreRepository;
import com.escaladeP6.beans.Membre;

import com.escaladeP6.beans.RoleMembre;
import com.escaladeP6.security.EncryptedPasswordUtils;
import com.escaladeP6.security.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    RoleMembreRepository roleMembreRepository;

    private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);


    @RequestMapping("/signUp")
    public String senregistrerForm (Model model){
        model.addAttribute("membre", new Membre());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String senregistrerSubmit(@ModelAttribute Membre membre){
        logger.info(" UN nouveau membre : " + membre.getNom() + " " + membre.getPrenom() + " " + membre.getPseudo() + " " + membre.getPseudo() + " " + membre.getEncryptedPassword());
        String encodedPassword = EncryptedPasswordUtils.encryptePassword(membre.getEncryptedPassword());
        //création du membre :
        Membre nouveauMembre = new Membre(membre.getNom(), membre.getPrenom(), membre.getPseudo(), encodedPassword, membre.getEmail());

        //sauvegarde du membre dans la table des membres
        membreRepository.save(nouveauMembre);

        //attribution d'un rôle au membre nouvellement créé
        roleMembreRepository.save(new RoleMembre(nouveauMembre, 2));


        return "index";


    }


}
