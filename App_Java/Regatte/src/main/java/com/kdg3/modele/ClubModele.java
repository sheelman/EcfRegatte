/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.modele;

/**
 *
 * @author sheelman
 */
public class ClubModele {
    
    int id;
    String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public ClubModele(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
        
    public ClubModele(int id) {
        this.id = id;
    }
    
    public ClubModele(String nom) {
        this.nom = nom;
    }

}
