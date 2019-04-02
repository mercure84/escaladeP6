package com.escaladeP6.controllers;


import com.escaladeP6.DAO.EmpruntTopoRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.EmpruntTopo;
import com.escaladeP6.beans.Topo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);


    @Autowired
    EmpruntTopoRepository empruntTopoRepository;

    @Autowired
    TopoRepository topoRepository;

    @RequestMapping(value="adminZone", method = RequestMethod.GET)
    public String administrer(Model model, Principal principal, String cleanE){


        if (cleanE !=null && cleanE.equals("oui")){

            List<EmpruntTopo> listeE = empruntTopoRepository.findEmpruntToposByEnCoursIsTrue();
            Date today = new Date();

        if (listeE.size()>=1) {
            int nbEmpruntsPurges = 0;
    for (int i = 0; i < listeE.size(); i++) {

        if ((listeE.get(i).getDateFinEmprunt().getTime() - today.getTime()) < 0) {

            EmpruntTopo monEmprunt = listeE.get(i);
            Topo monTopo = listeE.get(i).getTopo();

            monEmprunt.setEnCours(false);
            monTopo.setDisponible(true);

            empruntTopoRepository.save(monEmprunt);
            topoRepository.save(monTopo);
            nbEmpruntsPurges++;

            logger.info("Purge de l'emprunt : " + monEmprunt.getId());

        }
        //System.out.println("i vaut " + i);

    }
            logger.warn("Purge des emprunts effectuée par " + principal.getName() + ", nombre d'emprunts purgés : " + nbEmpruntsPurges);

        }

        logger.error("Aucun emprunt n'a été purgé");
        }

        return "adminZone";

    }

}
