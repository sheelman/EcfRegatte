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
public class ClasseModele {
    
    private int id;
    private String nom;
    private Float coefficient;
    private SerieModele serie;

    public ClasseModele(int id, String nom, Float coefficient, SerieModele serie) {
        this.id = id;
        this.nom = nom;
        this.coefficient = coefficient;
        this.serie = serie;
    }

    public ClasseModele(String nom, Float coefficient, SerieModele serie) {
        this.nom = nom;
        this.coefficient = coefficient;
        this.serie = serie;
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

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public SerieModele getSerie() {
        return serie;
    }

    public void setSerie(SerieModele serie) {
        this.serie = serie;
    }
    
    
}