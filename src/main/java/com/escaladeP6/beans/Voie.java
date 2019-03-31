package com.escaladeP6.beans;


import javax.persistence.*;

@Entity
@Table(name="voie")
public class Voie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="difficulte")
    private int difficulte;

    @Column(name="nom")
    private String nom;

    @Column(name="nom_site")
    private String nom_site;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="topo_id")
    private Topo topo;

    @Column(name="longueur")
    private int longueur;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_site() {
        return nom_site;
    }

    public void setNom_site(String nom_site) {
        this.nom_site = nom_site;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}
