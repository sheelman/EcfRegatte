package com.kdg3.rsultats.data.Modele;

import java.util.Date;

/**
 * Created by sheelman on 09/11/17.
 */

public class Regatte {

    int id;
    String nom;
    Date date;
    String lieu;
    int numero_course;
    int distance;
    int id_challenge;

    public Regatte(int id, String nom, Date date, String lieu, int numero_course, int distance, int id_challenge) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.numero_course = numero_course;
        this.distance = distance;
        this.id_challenge = id_challenge;
    }

    public Regatte(String nom, Date date, String lieu, int numero_course, int distance, int id_challenge) {
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.numero_course = numero_course;
        this.distance = distance;
        this.id_challenge = id_challenge;
    }


    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNumero_course() {
        return numero_course;
    }

    public void setNumero_course(int numero_course) {
        this.numero_course = numero_course;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId_challenge() {
        return id_challenge;
    }

    public void setId_challenge(int id_challenge) {
        this.id_challenge = id_challenge;
    }

    @Override
    public String toString() {
        return nom;
    }
}
