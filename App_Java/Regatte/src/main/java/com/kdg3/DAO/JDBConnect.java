/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sheelman
 */
public class JDBConnect {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            
        String url = "jdbc:mysql://localhost/regatteTest";
        String user = "admin";
        String passwd = "admin";
        conn = DriverManager.getConnection(url, user, passwd);  
        System.out.println("Connexion regatteTest!");

    } catch (Exception e) {
        e.printStackTrace();
    }
    return conn;
}

}
