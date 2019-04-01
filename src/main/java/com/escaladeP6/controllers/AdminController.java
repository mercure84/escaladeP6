package com.escaladeP6.controllers;


import com.escaladeP6.DAO.EmpruntTopoRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.batches.batchEmprunt;
import com.escaladeP6.beans.EmpruntTopo;
import com.escaladeP6.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller public class AdminController {

    @Autowired
    EmpruntTopoRepository empruntTopoRepository;

    @Autowired
    TopoRepository topoRepository;

    @RequestMapping(value="adminZone", method = RequestMethod.GET)
    public String administrer(Model model, Principal principal, String cleanE){

        System.out.println("cleanE vaut " + cleanE );

        if (cleanE !=null && cleanE.equals("oui")){

            System.out.println("je suis là");

            List<EmpruntTopo> listeE = empruntTopoRepository.findEmpruntToposByEnCoursIsTrue();
            Date today = new Date();

if (listeE.size()>=1) {
    for (int i = 0; i < listeE.size(); i++) {

        if ((int) (listeE.get(i).getDateFinEmprunt().getTime() - today.getTime()) < 0) {

            EmpruntTopo monEmprunt = listeE.get(i);
            Topo monTopo = listeE.get(i).getTopo();

            monEmprunt.setEnCours(false);
            monTopo.setDisponible(true);

            empruntTopoRepository.save(monEmprunt);
            //System.out.println("emprunt modifié = " + monEmprunt.getId());
            topoRepository.save(monTopo);
            //System.out.println("emprunt modifié = " + monTopo.getId());


        }
        //System.out.println("i vaut " + i);
    }
}
        }

        return "adminZone";

    }

}
