/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.regatte;


import com.kdg3.DAO.ClubDAO;

import com.kdg3.modele.ClubModele;
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
        
                List<ClubModele> clubs = ClubDAO.findAll();
                
                for (ClubModele club : clubs) {
			System.out.println(club);
		}
    }
    
}
