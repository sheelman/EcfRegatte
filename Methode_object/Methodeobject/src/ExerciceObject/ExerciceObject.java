/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciceObject;

import Modele.Commissaire;
import Modele.Licencie;
import Modele.Personne;
import Modele.Proprietaire;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


/**
 *
 * @author sheelman
 */
public class ExerciceObject {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        // Instanciation du jeu d'essai
        Proprietaire prop1 = new Proprietaire("Grand", "Schtroumpf", "Grand@Schtroumpf.fr", 1655);
        Proprietaire prop2 = new Proprietaire("Schtroumpf", "Costaud",	"Costaud@Schtroumpf.fr", 2000);
        Licencie lic1 = new Licencie("Schtroumpf", "Dormeur", "Dormeur@Schtroumpf.fr", 2001, 252525, 2017, 0);
        Licencie lic2 = new Licencie("Schtroumpf", "Fallassieux", "Fallassieux@Schtroumpf.uk", 1958, 253025, 2017, 0);
        Licencie lic3 = new Licencie("Schtroumpf", "Perdu", "Perdu@Schtroumpf.fr", 2002, 302530, 2017, 0);
        Commissaire com = new Commissaire("Schtroumpf", "Ché Pa Coder", "ChéPaCoder@Schtroumpf.fr", 1999, "La conté");


        // Préparation des dates du calculPoints le getInstance appel la date du jour, on la modifie pour comparaison
        //on fais 2 calcul 1 pour l'année en cours et un pour l'année pas en cours
        Calendar calcul1 = Calendar.getInstance();
        calcul1.set(2017, 01, 01);

        Calendar calcul2 = Calendar.getInstance();
        calcul2.set(2010, 01, 01);

        // Test de la méthode calculPoints avec la bonne date
        try {
            lic1.calculPoints(100, calcul1);
            lic1.calculPoints(50, calcul1);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Test de la méthode calculPoints avec la mauvaise date
        try {
            lic1.calculPoints(100, calcul2);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Ajout du jeu d'essai dans une collection
        List<Personne> personnes = new ArrayList<>();
        personnes.add(prop1);
        personnes.add(prop2);
        personnes.add(lic1);
        personnes.add(lic2);
        personnes.add(lic3);
        personnes.add(com);
        
        // Affichage de la collection
        for (Personne p : personnes) {
            System.out.println(p);
        }

        // Calcul de l'age moyen et de l'age médian
        System.out.println("Age moyen : " + moyAge(personnes));
        System.out.println("Age médian : " + medAge(personnes));
    }

    public static double moyAge(List<Personne> personnes) {

        double ageTot = 0;

        for (Personne p : personnes) {
            ageTot += p.getAge();
        }

        return ageTot / personnes.size();
    }

    public static double medAge(List<Personne> personnes) {

        // Passage en tableau d'age
        int[] ages = new int[personnes.size()];

        for (int i = personnes.size() - 1; i >= 0; i--) {
            ages[i] = personnes.get(i).getAge();
        }

        // Triage des ages
        Arrays.sort(ages);

        // Récupération de l'index du centre
        int i = ages.length / 2;

        // Calcul de l'age médian
        if (ages.length % 2 == 1) {
            return ages[i];
        } else {
            return (ages[i - 1] + ages[i]) / 2.0;
        }
    }
}
