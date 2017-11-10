/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;



import java.util.Calendar;

/**
 * 
 * @author sheelman
 */
public class Personne {
    
    String nom;
    String prenom;
    String email;
    int annee_naissance;

    public Personne(String nom, String prenom, String email, int annee_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.annee_naissance = annee_naissance;
    }
    
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - annee_naissance;
    }

    @Override
    public String toString() {
        return "Personne [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", age=" + getAge() + "]";
    }
}
