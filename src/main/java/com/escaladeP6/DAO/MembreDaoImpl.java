package com.escaladeP6.DAO;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


public class MembreDaoImpl implements MembreDao {

    JdbcTemplate jdbcTemplate;


    @Override
    public void creerMembre() {

        System.out.println("rien");
    }

    @Override
    public void supprimerMembre() {
        System.out.println("rien");

    }

    @Override
    public void updateMembre() {
        System.out.println("encore rien");

    }
}
