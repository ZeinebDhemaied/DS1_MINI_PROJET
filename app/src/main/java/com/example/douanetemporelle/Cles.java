package com.example.douanetemporelle;

public class Cles {

    public static final String MATRICULE = "1234";

    // methode tasna3 el cle: matricule + "_" + esm el cle
    public static String cle(String matricule, String nom) {
        return matricule + "_" + nom;
    }
}