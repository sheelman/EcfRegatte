/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.regatte;

import com.kdg3.vue.CreationVoilierGui;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sheelman
 */
public class CreationVoilier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            JFrame frame = new JFrame("Création de voilier");
            JPanel panel = new CreationVoilierGui();
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
    }
    
}
