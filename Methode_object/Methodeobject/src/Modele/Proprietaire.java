/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author sheelman
 */
public class Proprietaire extends Personne{
    
    public Proprietaire(String nom, String prenom, String email, 
				int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
    }
    
    @Override
    public String toString() {
        return "Proprietaire [" + super.toString() + "]";
    }
}
