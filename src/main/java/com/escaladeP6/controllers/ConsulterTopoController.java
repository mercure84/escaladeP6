package com.escaladeP6.controllers;


import com.escaladeP6.DAO.CommentaireRepository;
import com.escaladeP6.DAO.TopoRepository;
import com.escaladeP6.DAO.VoieRepository;
import com.escaladeP6.beans.*;

import com.escaladeP6.security.ApplicationProperties;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Controller
public class ConsulterTopoController {

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    CommentaireRepository commentaireRepository;

    @Autowired
    VoieRepository voieRepository;


@RequestMapping("/topoConsulter")
public String topos (Model model){
    // liste des département générée depuis l'enum
    ArrayList<Integer> listeNumDpt = new ArrayList<Integer>();
    for (Departement dept : Departement.values()){
        listeNumDpt.add(dept.getNumDpt());

    }

    List<Topo> testTopos = topoRepository.findAll();
        model.addAttribute("topos", topoRepository.findAll());
        model.addAttribute("listeDept", listeNumDpt);
        model.addAttribute("filtre", new Filtre());


        return "topoConsulter";
}

@PostMapping("/topoConsulter")
    public String topoSearch(@ModelAttribute Filtre filtre, Model model){
    // liste des département générée depuis l'enum
    ArrayList<Integer> listeNumDpt = new ArrayList<Integer>();
    for (Departement dept : Departement.values()){
        listeNumDpt.add(dept.getNumDpt());
    }
    model.addAttribute("listeDept", listeNumDpt);

    // traitement du nb de voies
    int nbVoiesMin = 0;
    int nbVoiesMax = 0;

    switch(filtre.getNbVoies()){
         case 1:
            nbVoiesMax = 10;
             System.out.println("on est cas 1, nbVoieMin =" + nbVoiesMin + " nbVoiesMax = " + nbVoiesMax);
            break;
        case 2:
            nbVoiesMin = 11;
            nbVoiesMax = 20;
            System.out.println("on est cas 1, nbVoieMin =" + nbVoiesMin + " nbVoiesMax = " + nbVoiesMax);
            break;
        case 3:
            nbVoiesMin = 21;
            nbVoiesMax = 1000;
            System.out.println("on est cas 1, nbVoieMin =" + nbVoiesMin + " nbVoiesMax = " + nbVoiesMax);

    }

    model.addAttribute("topos", topoRepository.filtrerTopos(filtre.getDepartement(), filtre.getDifficulte(), filtre.isDisponible(), nbVoiesMin, nbVoiesMax));
    return "topoConsulter";

}

    @RequestMapping("/topoConsulter/fichiers")
    public @ResponseBody void dlFichier(String topoId, HttpServletResponse response ) throws SQLException, IOException {

        //recherche du fichier config.properties
        ApplicationProperties dbProp = new ApplicationProperties();
        Connection conn = DriverManager.getConnection(dbProp.getUrlPG(), dbProp.getUserPG(), dbProp.getPasswordPG());
        PreparedStatement ps = conn.prepareStatement("SELECT topo.fichier FROM topo WHERE id=?");
        ps.setInt(1, Integer.parseInt(topoId));
        ResultSet rs = ps.executeQuery();
        String localPath = System.getProperty("user.dir");
        String nomPDF = topoId+".pdf";
        String path = localPath + "/fichiers/topo"+ nomPDF;

        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);

            if (rs != null) {
            while (rs.next()) {
                //sortie du fichier de la BDD
                byte[] fichier = rs.getBytes("fichier");


                fos.write(fichier);
            }}
                //renvoie du fichier dans la réponse via un FIS
                response.setContentType("application/pdf");

                File fileIS = new File(path);
                FileInputStream fis = new FileInputStream(fileIS);
                IOUtils.copy(fis, response.getOutputStream());

                response.setHeader("Content-Disposition", "inline; filename=" + path+";" );
                fos.close();
                fis.close();

            rs.close();

        ps.close();

    }

@RequestMapping(value="/topoDetails", method = RequestMethod.GET)
public String pageDetails(String topoId, Model model){

    //recherche du topo concerné :
    Topo topoCible = topoRepository.findTopoById(Integer.parseInt(topoId));

    //instanciation d'un nouveau commentaire
    Commentaire commentaire = new Commentaire();

    //recherche des commentaires du topo
    List<Commentaire> commentaireList = commentaireRepository.findCommentairesByTopoOrderByDateDesc(topoCible);

    model.addAttribute("commentaireList", commentaireList);
    model.addAttribute("topo", topoCible);
    model.addAttribute("commentaire", commentaire);
   return  "topoDetails";

}

@RequestMapping(value="/topoVoiesDetails", method = RequestMethod.GET)
public String detailsVoies(String topoId, Model model){

    Topo topo = topoRepository.findTopoById(Integer.parseInt(topoId));
    List<Voie> listeVoies = voieRepository.findVoiesByTopo(topo);

    model.addAttribute("topo", topo);
    model.addAttribute("listeVoies", listeVoies);

    return "topoVoiesDetails";
}



}

