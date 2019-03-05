package com.escaladeP6.tutoTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testFichier {


    public static void main(String[] args) throws SQLException {

//        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/escap6", "postgres", "chatons2019");
//
//        PreparedStatement ps = conn.prepareStatement("INSERT INTO testfichiers VALUES (?, ?)");
//
//
//        //traitement du fichier
//        File file = new File("fichiers/TOPO1.pdf");
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            ps.setString(1, "fichierAlaCon");
//            ps.setBinaryStream(2, fis, file.length());
//            ps.executeUpdate();
//            ps.close();
//            fis.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

}}
