package com.escaladeP6.tutoTest;

import com.escaladeP6.beans.Departement;

import java.util.ArrayList;


public class testConsole {

    public static void main(String[] args) {
        ArrayList<Integer> listeDpt = new ArrayList<Integer>();

        for (Departement dept : Departement.values()){

            listeDpt.add(dept.getNumDpt());
        }

        System.out.println(listeDpt);
    }

}
