package com.escaladeP6.beans;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name="topo")
public class Topo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="fichier")
    private MultipartFile[] fichier;

    @Column(name="nom")
    private String nom;

    @Column(name="description")
    private String description;

    @Column(name="disponible")
    private boolean disponible;

    @Column(name="a_valider")
    private boolean valide;

    @Column(name="difficulte")
    private String difficulte;

//    @OneToMany()
//    private Membre membre;

    @Column(name="membre_id")
    private int membreId;

    //accesseurs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile[] getFichier() {
        return fichier;
    }

    public void setFichier(MultipartFile[] fichier) {
        this.fichier = fichier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public int getMembreId() {
        return membreId;
    }

    public void setMembreId(int membreId) {
        this.membreId = membreId;
    }


    //Constructeurs

    public Topo() {
    }

    public Topo(String nom, String description, String difficulte, boolean disponible, boolean valide, int membreId) {
        this.nom = nom;
        this.description = description;
        this.difficulte = difficulte;
        this.disponible = disponible;
        this.valide = valide;
        this.membreId = membreId;

    }


}
