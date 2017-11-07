/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sheelman
 */
public class JDBConnect {
    
        private static Connection conn = null;
        //information d'accès à la base de données
        final static String URL = "jdbc:mysql://localhost/regatteTest";

    /**
     *
     * @return RunTimeException() if any pb
     */
    public static Connection getConnection() {
        if (conn == null) {

            try {
                try {
                    // Etape 1 : chargement du driver
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    //visualisation dans la console que driver est chargé
                    System.out.println("Driver O.K.");
                    
                    
                } catch (InstantiationException ex) {
                    Logger.getLogger(JDBConnect.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(JDBConnect.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JDBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                //Etape 2 : récupération de la connection
                conn = DriverManager.getConnection(URL, "admin", "admin");
                //visualisation dans la console que connexion BDD effectué
                System.out.println("Connexion regatteTest!");
            } catch (SQLException ex) {
                //Si la connection ce fait pas montre les exception
                Logger.getLogger(JDBConnect.class.getName()).log(Level.SEVERE, null, ex);
                //visualisation dans la console que la connexion a échoué
                System.out.println("la connexion est echoué");
            }
           
        }

        return conn;

    }

}
