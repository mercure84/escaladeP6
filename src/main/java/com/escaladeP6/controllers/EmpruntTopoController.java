package com.escaladeP6.controllers;

import com.escaladeP6.DAO.EmpruntTopoRepository;
import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.EmpruntTopo;
import com.escaladeP6.beans.Membre;
import com.escaladeP6.beans.Topo;
import com.escaladeP6.security.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class EmpruntTopoController {


    private static final Logger logger = LoggerFactory.getLogger(EmpruntTopoController.class);

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    EmpruntTopoRepository empruntTopoRepository;

    @RequestMapping(value="/topoEmprunter", method = RequestMethod.GET)
    public String pageEmprunt(Model model, Principal principal, String topoId){
        EmpruntTopo empruntTopo = new EmpruntTopo();
        //recherche du topo concerné :
        Topo topoCible = topoRepository.findTopoById(Integer.parseInt(topoId));
        model.addAttribute("empruntTopo", empruntTopo);
        model.addAttribute("topo", topoCible);
        //controle faille URL : si le topo n'est pas disponible ==> erreur !
        if (!topoCible.isDisponible()){
            return "error";
        }
           return "topoEmprunter";
 }

 @PostMapping("/topoEmprunter")
 public String emprunterTopo(@ModelAttribute EmpruntTopo empruntTopo, Principal principal, String topoId){

     User loginedUser = (User) ((Authentication) principal).getPrincipal();
     String pseudo = loginedUser.getUsername();
     Topo topo = topoRepository.findTopoById(Integer.parseInt(topoId));
     Membre membre = membreRepository.findMembreByPseudo(pseudo);

     empruntTopo.setMembre(membre);
     empruntTopo.setTopo(topo);
     empruntTopo.setDateEmprunt(new Date());


     //enregistrement de l'emprunt
     empruntTopoRepository.save(empruntTopo);

     //le topo concerné devient indispo
     topo.setDisponible(false);
     topoRepository.save(topo);

     logger.warn ("Un nouvel emprunt a été créé par " + membre.getPseudo() + " pour le topo n° " + topo.getNom());

     return "redirect:topoHome";


 }

 @RequestMapping(value="/empruntConsulter", method = RequestMethod.GET)
    public String listeEmprunts(Model model, Principal principal){

// liste des emprunts

     List<EmpruntTopo> listeE = empruntTopoRepository.findEmpruntToposByEnCoursIsTrue();

     model.addAttribute("listeEmprunts", listeE);

        return "empruntConsulter";
 }




}
