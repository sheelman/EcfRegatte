/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.regatte;

import com.kdg3.DAO.SerieDAO;
import com.kdg3.vue.CreationVoilier;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author sheelman
 */
public class LauncherCreationVoilier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        JFrame frame = new CreationVoilier();
        frame.pack();
        frame.setVisible(true);
    }
    
}
