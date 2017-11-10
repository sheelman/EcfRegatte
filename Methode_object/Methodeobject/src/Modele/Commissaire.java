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
public class Commissaire extends Personne{
    
    String commite;
    
    public Commissaire(String nom, String prenom, String email, 
				int anneeNaissance, String commite) {
        super(nom, prenom, email, anneeNaissance);
        this.commite = commite;
    }
      
    @Override
    public String toString() {
        return "Commissaire [commite=" + commite + ", " + super.toString() + "]";
    }
}
