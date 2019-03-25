package com.escaladeP6.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="memo")
    private String memo;

    @Temporal(TemporalType.TIME)
    private Date date;

    @ManyToOne()
    @JoinColumn(name="membre_id")
    private Membre membre;

    @ManyToOne()
    @JoinColumn(name="topo_id")
    private Topo topo;


//    GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
