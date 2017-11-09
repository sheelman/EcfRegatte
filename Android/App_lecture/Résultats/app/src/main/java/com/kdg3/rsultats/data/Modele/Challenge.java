package com.kdg3.rsultats.data.Modele;

import java.util.Date;

/**
 * Created by sheelman on 08/11/17.
 */

public class Challenge {

    int id;
    String code;
    String nom;
    Date date_debut;
    Date date_fin;

    public Challenge(int id, String code, String nom, Date date_debut, Date date_fin) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Challenge(String code, String nom, Date date_debut, Date date_fin) {
        this.code = code;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId() { return id;  }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return nom;
    }
}
