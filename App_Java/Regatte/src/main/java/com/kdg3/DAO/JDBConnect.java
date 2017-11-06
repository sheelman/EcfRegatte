/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sheelman
 */
public class JDBConnect {
    public static Connection getConnection() {
        
        //information d'accès à la base de données
        String url = "jdbc:mysql://localhost/regatteTest";
        String user = "admin";
        String passwd = "admin";
        Connection con = null;
        
        try {
            // Etape 1 : chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //visualisation dans la console que driver est chargé
            System.out.println("Driver O.K.");
            
            //Etape 2 : récupération de la connection            
            con = DriverManager.getConnection(url, user, passwd);
            //visualisation dans la console que connexion BDD effectué
            System.out.println("Connexion regatteTest!");
                        

    } catch (ClassNotFoundException | SQLException e) {
        //Si la connection ce fait pas montre les exception
        e.printStackTrace();
        //visualisation dans la console que la connexion a échoué
        System.out.println("la connexion est echoué");
    }
    return con;
}

}
