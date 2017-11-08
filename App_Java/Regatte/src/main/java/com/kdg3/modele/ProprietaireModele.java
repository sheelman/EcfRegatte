/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.modele;

import java.util.Date;

/**
 *
 * @author sheelman
 */
public class ProprietaireModele extends PersonneModele{
    
    private int id;
    private ClubModele club;

    public ProprietaireModele(int id, ClubModele club, int id_personne, String nom, String prenom, String adresse, String code_postal, String ville, String telephone, String email, Date date_naissance, boolean affilie_FFV, String numero_licence, Date date_licence) {
        super(id_personne, nom, prenom, adresse, code_postal, ville, telephone, email, date_naissance, affilie_FFV, numero_licence, date_licence);
        this.id = id;
        this.club = club;
    }

    public ProprietaireModele(ClubModele club, String nom, String prenom, String adresse, String code_postal, String ville, String telephone, String email, Date date_naissance, boolean affilie_FFV, String numero_licence, Date date_licence) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email, date_naissance, affilie_FFV, numero_licence, date_licence);
        this.club = club;
    }

    public ProprietaireModele(int id, ClubModele club, int id_personne, String nom, String prenom) {
        super(id_personne, nom, prenom);
        this.id = id;
        this.club = club;
    }

    public ProprietaireModele(ClubModele club, String nom, String prenom) {
        super(nom, prenom);
        this.club = club;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //va chercher le getId de la classe parent dans personneModele
    public int getId_personne() {
        return super.getId();
    }
    
    public ClubModele getClub() {
        return club;
    }

    public void setClub(ClubModele club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
