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
public class Licencie extends Personne{
    
    int numLicence;
    int anneeLicence;
    double pointsFFV;
    
    public Licencie(String nom, String prenom, String email, int anneeNaissance, 
				int numLicence, int anneeLicence, double pointsFFV) {
        super(nom, prenom, email, anneeNaissance);
        this.numLicence = numLicence;
        this.anneeLicence = anneeLicence;
        this.pointsFFV = pointsFFV;
    }
     
    public void calculPoints(int nombre, Calendar cal) throws Exception {
        if (anneeLicence != cal.get(Calendar.YEAR)) {
            throw new Exception();
        }
        pointsFFV += nombre;
    }
    
    @Override
    public String toString() {
        return "Licencie [numLicence=" + numLicence + ", anneeLicence=" + anneeLicence + ", pointsFFV=" + pointsFFV + ", " + super.toString() + "]";
    }
}
