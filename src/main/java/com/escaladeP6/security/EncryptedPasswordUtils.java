package com.escaladeP6.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtils {

    //encrypte le pass word avec Bcrypt
    public static String encryptePassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);

    }

    //un test de l'encodage
    public static void main(String[] args) {

        String mot = "expression à crypter !";
        System.out.println("Cela nous donne : " + encryptePassword(mot));

    }


}
