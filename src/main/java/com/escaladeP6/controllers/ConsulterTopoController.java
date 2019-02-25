package com.escaladeP6.controllers;


import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ConsulterTopoController {

    @Autowired
    TopoRepository repository;


////requête de la BDD pour lister tous les topos
////@RequestMapping("/topoConsulter")
//    public @ResponseBody Iterable<Topo> getAllTopos(){
//        //System.out.println(repository.findAll());
//        return repository.findAll();
//    }

@RequestMapping("/topoConsulter")
public String topos (Model model){


        model.addAttribute("topos", repository.findAll());
        return "topoConsulter";
}

}
