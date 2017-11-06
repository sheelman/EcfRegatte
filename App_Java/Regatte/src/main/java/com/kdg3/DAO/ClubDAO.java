/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import com.kdg3.modele.ClubModele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sheelman
 */
public class ClubDAO {
    //**************************** R READ  *************************************
     /**
     * retourne la liste club
     *
     * @return
     */
    
    public static List<ClubModele> findAll() throws SQLException {

        Connection c = JDBConnect.getConnection();

        List<ClubModele> ListClubs = new ArrayList<>();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from club";
            ResultSet rs = stm.executeQuery(sql);
            
                while (rs.next()) {
                    int id = rs.getInt("club.id");
                    String nom = rs.getString("club.nom");
                    
                    ClubModele clm = new ClubModele(id, nom);
                                        
                    ListClubs.add(clm);
                }
                rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ListClubs;
    }

    public static ClubModele findOnedById(int id) {
        
        ClubModele clm = null;
        Connection c = JDBConnect.getConnection();
        Statement stm;
        
        try {
            stm = c.createStatement();
            
            String sql="select * from club WHERE club.id="+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()) {
                String nom = rs.getString("club.nom");
                clm = new ClubModele(id, nom);
            }
            
        } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException();
        }

        return clm;
    }
    
    /**
    *CRUD
    *
    */
    //*************************** C CREATE *************************************
    public static void create(ClubModele clm) throws Exception {

        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO club (nom) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, clm.getNom());

        stm.execute();
        ResultSet rs = stm.getGeneratedKeys();

        if (rs.next()) {
            clm.setId(rs.getInt(1));
        }
        stm.close();
    }
    
    //***************************** U UPDATE ***********************************
    public static void update(ClubModele clm) throws Exception {
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("UPDATE club SET nom = ? WHERE id = ?");
            stm.setString(1, clm.getNom());
            stm.setInt(2, clm.getId());

            stm.executeUpdate();

        } catch (SQLException e) {

            throw new Exception("pb lors de la mise a jour de club:" + e.getMessage());
        }
    }
    
    //**************************** D DELETE ************************************
    public static void delete(ClubModele clm) throws Exception {
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("DELETE FROM club WHERE id = ?");
            stm.setInt(1, clm.getId());

            stm.executeUpdate();

        } catch (SQLException e) {

            throw new Exception("pb lors de la suppression de club:" + e.getMessage());
        }
    }
}
