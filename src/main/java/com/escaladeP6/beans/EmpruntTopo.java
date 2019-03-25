package com.escaladeP6.beans;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="emprunt")
public class EmpruntTopo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date_emprunt")
    private Date dateEmprunt;

    @Column(name="date_fin_emprunt")
    private Date dateFinEmprunt;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="membre_id")
    private Membre membre;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="topo_id")
    private Topo topo;


    //ACCESSEURS

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
}
