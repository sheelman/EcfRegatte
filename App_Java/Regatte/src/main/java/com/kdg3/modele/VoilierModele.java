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
public class VoilierModele {
    
    private int id;
    private int numero_voile;
    private ProprietaireModele proprietaire;
    private ClasseModele classe;

    public VoilierModele(int id, int numero_voile, ProprietaireModele proprietaire, ClasseModele classe) {
        this.id = id;
        this.numero_voile = numero_voile;
        this.proprietaire = proprietaire;
        this.classe = classe;
    }

    public VoilierModele(int numero_voile, ProprietaireModele proprietaire, ClasseModele classe) {
        this.numero_voile = numero_voile;
        this.proprietaire = proprietaire;
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_voile() {
        return numero_voile;
    }

    public void setNumero_voile(int numero_voile) {
        this.numero_voile = numero_voile;
    }

    public ProprietaireModele getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(ProprietaireModele proprietaire) {
        this.proprietaire = proprietaire;
    }

    public ClasseModele getClasse() {
        return classe;
    }

    public void setClasse(ClasseModele classe) {
        this.classe = classe;
    }

   
}
