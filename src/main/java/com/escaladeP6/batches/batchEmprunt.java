package com.escaladeP6.batches;

import com.escaladeP6.DAO.EmpruntTopoRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.EmpruntTopo;
import com.escaladeP6.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class batchEmprunt {

    @Autowired
    EmpruntTopoRepository empruntTopoRepository;

    @Autowired
    TopoRepository topoRepository;

    public batchEmprunt() {
    }

    /**
     * fonction qui permet de rendre les topos disponibles quand leurs emprunts sont finis
     */
    public void purgerEmprunts(){

        List<EmpruntTopo> listeE = empruntTopoRepository.findEmpruntToposByEnCoursIsTrue();




    }


}
