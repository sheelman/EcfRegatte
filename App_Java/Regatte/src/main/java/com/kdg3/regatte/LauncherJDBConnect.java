/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.regatte;

import static com.kdg3.DAO.JDBConnect.getConnection;


/**
 *
 * @author sheelman
 */
public class LauncherJDBConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getConnection();
    }
}
