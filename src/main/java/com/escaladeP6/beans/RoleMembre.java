package com.escaladeP6.beans;


import javax.persistence.*;

@Entity
@Table(name="user_role")
public class RoleMembre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false, unique = true)
    private int id;


    @ManyToOne
    @JoinColumn(name="membre_id")
    private Membre membre;

    @JoinColumn(name="role_id")
    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public RoleMembre(Membre membre, int roleId) {
        this.membre = membre;
        this.roleId = roleId;
    }

    public RoleMembre() {
    }
}
