package com.escaladeP6.beans;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="emprunt")
public class EmpruntTopo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date_emprunt")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateEmprunt;

    @Column(name="date_fin_emprunt")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateFinEmprunt;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="membre_id")
    private Membre membre;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="topo_id")
    private Topo topo;

    @Column(name="en_cours")
    private boolean enCours = true;


    //ACCESSEURS


    public boolean isEnCours() {
        return enCours;
    }

    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateFinEmprunt() {
        return dateFinEmprunt;
    }

    public void setDateFinEmprunt(Date dateFinEmprunt) {
        this.dateFinEmprunt = dateFinEmprunt;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }


    //CONSTRUCTEURS


    public EmpruntTopo() {
    }


    //fonction utilitaire


    public int joursRestants(Date finEmprunt){

        Date now = new Date();

int nbJours = (int) (finEmprunt.getTime() - now.getTime())/(24*60*60*1000);

        return nbJours;
    }



}
