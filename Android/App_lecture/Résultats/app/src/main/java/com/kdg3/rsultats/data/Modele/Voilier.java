package com.kdg3.rsultats.data.Modele;

/**
 * Created by sheelman on 09/11/17.
 */

public class Voilier {

    int id;
    int numero_voile;
    int id_proprietaire;
    int id_class;

    public Voilier(int id, int numero_voile, int id_proprietaire, int id_class) {
        this.id = id;
        this.numero_voile = numero_voile;
        this.id_proprietaire = id_proprietaire;
        this.id_class = id_class;
    }

    public Voilier(int numero_voile, int id_proprietaire, int id_class) {
        this.numero_voile = numero_voile;
        this.id_proprietaire = id_proprietaire;
        this.id_class = id_class;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getNumero_voile() {
        return numero_voile;
    }

    public void setNumero_voile(int numero_voile) {
        this.numero_voile = numero_voile;
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }

    public void setId_proprietaire(int id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }
}
