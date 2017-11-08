/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.regatte;


import com.kdg3.DAO.ClasseDAO;
import com.kdg3.DAO.ClubDAO;
import com.kdg3.DAO.PersonneDAO;
import com.kdg3.DAO.ProprietaireDAO;
import com.kdg3.DAO.SerieDAO;
import com.kdg3.DAO.VoilierDAO;
import com.kdg3.modele.ClasseModele;

import com.kdg3.modele.ClubModele;
import com.kdg3.modele.PersonneModele;
import com.kdg3.modele.ProprietaireModele;
import com.kdg3.modele.SerieModele;
import com.kdg3.modele.VoilierModele;
import java.util.List;

/**
 *
 * @author sheelman
 */
public class TestDAO {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
                List<ClasseModele> classes = ClasseDAO.findAll();
                List<ClubModele> clubs = ClubDAO.findAll();
                List<PersonneModele> personnes = PersonneDAO.findAll();
                List<ProprietaireModele> proprietaires = ProprietaireDAO.findAll();
                List<SerieModele> series = SerieDAO.findAll();
                List<VoilierModele> voiliers = VoilierDAO.findAll();
                
                for (ClasseModele classe : classes) {
			System.out.println(classe);
		}
                
                for (ClubModele club : clubs) {
			System.out.println(club);
		}
                
                for (PersonneModele personne : personnes) {
			System.out.println(personne);
		}
                
                for (ProprietaireModele proprietaire : proprietaires) {
			System.out.println(proprietaire);
		}
                
                for (SerieModele serie : series) {
			System.out.println(serie);
		}
                
                for (VoilierModele voilier : voiliers) {
			System.out.println(voilier);
		}
    }
    
}
