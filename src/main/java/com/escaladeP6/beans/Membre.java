package com.escaladeP6.beans;

import javax.persistence.*;
import java.util.Date;




@Entity
@Table(name="membre")
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="pseudo")
    private String pseudo;

    @Column(name="password")
    private String password;

    @Column(name="date_naissance")
    private Date dateNaissance;

    @Column(name="email")
    private String email;

    @Column(name="tel_mobile")
    private long telMobile;

    @Column(name="date_inscription")
    private Date dateInscription;

    @Column(name="role")
    private String role;

    @Column(name="code_postal")
    private int codePostal;

    @Column(name="ville")
    private String ville;

    @Column(name="a_valider")
    private boolean valide;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(long telMobile) {
        this.telMobile = telMobile;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }


    //constructeurs
    public Membre(){

    }

    public Membre(String nom, String prenom, String pseudo, String password, Date dateNaissance, String email, int telMobile, Date dateInscription, String role, int codePostal, String ville, boolean valide) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telMobile = telMobile;
        this.dateInscription = dateInscription;
        this.role = role;
        this.codePostal = codePostal;
        this.ville = ville;
        this.valide = valide;
    }

    public Membre(String nom, String prenom, String pseudo, String password, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", email='" + email + '\'' +
                ", telMobile=" + telMobile +
                ", dateInscription=" + dateInscription +
                ", role='" + role + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                ", valide=" + valide +
                '}';
    }
}



