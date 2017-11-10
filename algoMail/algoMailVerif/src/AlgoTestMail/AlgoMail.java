/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoTestMail;

/**
 *
 * @author sheelman
 */
public class AlgoMail {
    
    public Boolean mail(String email) {
        //décomposer un mail en tableau on donne comme point d'arret le @ via un split ce qui fait que l'on ce trouve avec 2 tableau un avnt le @ et un après
        String[] e = email.split("@");
        //On vérifie la longueur du tableau et on lui dit que strictement = 2 tableau sinon on retourn faux
        if (e.length == 2) {
            //on lui dit de créer dans le 2 ème tableau un autre point de split obligatoire au point
            String[] tabDroite = e[1].split("\\.");
            //On vérifie la longueur du tableau et on lui dit que strictement >= 2 tableau sinon on retourn faux
            if (tabDroite.length >= 2) {
                //On lui dit de vérifier si après @ la longueur des donné contenu dans les tableaux sont >= 2
                if (tabDroite[0].length() >= 2 && tabDroite[1].length() >= 2) {
                    if (e[0].length() >= 2) {
                        return true;
                    }
                }
        

            }

        }
        return false;
    }

}
