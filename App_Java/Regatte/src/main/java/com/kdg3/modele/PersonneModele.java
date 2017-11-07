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
public class PersonneModele {
    
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String code_postal;
    private String ville;
    private String telephone;
    private String email;
    private Date date_naissance;
    private boolean affilie_FFV;
    private String numero_licence;
    private Date date_licence;

    public PersonneModele(int id, String nom, String prenom, String adresse, String code_postal, String ville, String telephone, String email, Date date_naissance, boolean affilie_FFV, String numero_licence, Date date_licence) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.date_naissance = date_naissance;
        this.affilie_FFV = affilie_FFV;
        this.numero_licence = numero_licence;
        this.date_licence = date_licence;
    }

    public PersonneModele(String nom, String prenom, String adresse, String code_postal, String ville, String telephone, String email, Date date_naissance, boolean affilie_FFV, String numero_licence, Date date_licence) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.date_naissance = date_naissance;
        this.affilie_FFV = affilie_FFV;
        this.numero_licence = numero_licence;
        this.date_licence = date_licence;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public boolean isAffilie_FFV() {
        return affilie_FFV;
    }

    public void setAffilie_FFV(boolean affilie_FFV) {
        this.affilie_FFV = affilie_FFV;
    }

    public String getNumero_licence() {
        return numero_licence;
    }

    public void setNumero_licence(String numero_licence) {
        this.numero_licence = numero_licence;
    }

    public Date getDate_licence() {
        return date_licence;
    }

    public void setDate_licence(Date date_licence) {
        this.date_licence = date_licence;
    }

    
}
