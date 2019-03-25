package com.escaladeP6.beans;


import javax.persistence.*;

@Entity
@Table(name="topo")
public class Topo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="fichier")
    private byte[] fichier;



    @Column(name="nom_fichier")
    private String nomFichier;

    @Column(name="nom")
    private String nom;

    @Column(name="description")
    private String description;

    @Column(name="departement")
    private int departement;

    @Column(name="disponible")
    private boolean disponible;

    @Column(name="a_valider")
    private boolean valide;

    @Column(name="difficulte")
    private String difficulte;


    @Column(name="nb_voies")
    private int nbVoies;


    @ManyToOne()
    @JoinColumn(name="membre_id")
    private Membre membre;


    //accesseurs
    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }
    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getFichier() {
        return fichier;
    }

    public void setFichier(byte[] fichier) {
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


    public int getDepartement() {return departement;}

    public void setDepartement(int departement) {this.departement = departement;
    }

    public int getNbVoies() {
        return nbVoies;
    }

    public void setNbVoies(int nbVoies) {
        this.nbVoies = nbVoies;
    }

    //Constructeurs

    public Topo() {
    }

    public Topo(String nom, String description, int departement, String difficulte, int nbVoies, boolean disponible, boolean valide, Membre membre) {
        this.nom = nom;
        this.description = description;
        this.difficulte = difficulte;
        this.nbVoies = nbVoies;
        this.disponible = disponible;
        this.valide = valide;
        this.membre = membre;
        this.departement = departement;

    }


}
