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
}
