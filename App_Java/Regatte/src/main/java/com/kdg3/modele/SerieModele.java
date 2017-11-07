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
public class SerieModele {
    
    private int id;
    private String nom;

    public SerieModele(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public SerieModele(String nom) {
        this.nom = nom;
    }

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

 
}
