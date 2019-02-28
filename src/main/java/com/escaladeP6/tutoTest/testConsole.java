package com.escaladeP6.tutoTest;


/**
 * test de script fizz buzzz :)
 */
public class testConsole {

    public static void main(String[] args) {

        for (int i=0 ; i<100 ; i++){


            System.out.println(i + " " + testNombre(i));


        }
    }

    public static String testNombre(int nombre){
        String retour ="";

        if(nombre%3 == 0){
retour += "Fizz";
        }
        if (nombre %5 ==0){

            retour +="Buzz";
        }
return retour;
    }


}
