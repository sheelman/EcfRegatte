package com.kdg3.rsultats.data.Modele;

import java.sql.Time;

/**
 * Created by sheelman on 09/11/17.
 */

public class Course {

    int id;
    String numero_inscription_valide;
    int nombre_point;
    Time temps_reel;
    int position;
    int id_regatte;
    int id_voilier;
    int id_equipage;
    int id_code;

    public Course(int id, String numero_inscription_valide, int nombre_point, Time temps_reel, int position, int id_regatte, int id_voilier, int id_equipage, int id_code) {
        this.id = id;
        this.numero_inscription_valide = numero_inscription_valide;
        this.nombre_point = nombre_point;
        this.temps_reel = temps_reel;
        this.position = position;
        this.id_regatte = id_regatte;
        this.id_voilier = id_voilier;
        this.id_equipage = id_equipage;
        this.id_code = id_code;
    }

    public Course(String numero_inscription_valide, int nombre_point, Time temps_reel, int position, int id_regatte, int id_voilier, int id_equipage, int id_code) {
        this.numero_inscription_valide = numero_inscription_valide;
        this.nombre_point = nombre_point;
        this.temps_reel = temps_reel;
        this.position = position;
        this.id_regatte = id_regatte;
        this.id_voilier = id_voilier;
        this.id_equipage = id_equipage;
        this.id_code = id_code;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_inscription_valide() {
        return numero_inscription_valide;
    }

    public void setNumero_inscription_valide(String numero_inscription_valide) { this.numero_inscription_valide = numero_inscription_valide; }

    public int getNombre_point() {
        return nombre_point;
    }

    public void setNombre_point(int nombre_point) {
        this.nombre_point = nombre_point;
    }

    public Time getTemps_reel() {
        return temps_reel;
    }

    public void setTemps_reel(Time temps_reel) {
        this.temps_reel = temps_reel;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getId_regatte() {
        return id_regatte;
    }

    public void setId_regatte(int id_regatte) {
        this.id_regatte = id_regatte;
    }

    public int getId_voilier() {
        return id_voilier;
    }

    public void setId_voilier(int id_voilier) {
        this.id_voilier = id_voilier;
    }

    public int getId_equipage() {
        return id_equipage;
    }

    public void setId_equipage(int id_equipage) {
        this.id_equipage = id_equipage;
    }

    public int getId_code() {
        return id_code;
    }

    public void setId_code(int id_code) {
        this.id_code = id_code;
    }

    @Override
    public String toString() {
        return  "voilier :" + id_voilier +
                ", nombre_point=" + nombre_point +
                ", temps_reel=" + temps_reel +
                ", position=" + position +
                '}';
    }
}
