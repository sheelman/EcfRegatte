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
import java.util.logging.Level;
import java.util.logging.Logger;

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
      * @throws SQLException 
      */
    
    public static List<ClubModele> findAll() {

        Connection c = JDBConnect.getConnection();

        List<ClubModele> ListClubs = new ArrayList<>();
        Statement stm;
        
        try {
            stm = c.createStatement();

            String sql = "select * from club";
            ResultSet rs = stm.executeQuery(sql);
            
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    
                    ClubModele clm = new ClubModele(id, nom);
                                        
                    ListClubs.add(clm);
                }
                rs.close();
                return ListClubs;
                
        }catch(SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public static ClubModele findOnedById(int id) {
        
        ClubModele clm = null;
        Connection c = JDBConnect.getConnection();
        Statement stm;
        
        try {
            stm = c.createStatement();
            
            String sql="select * from club WHERE id="+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()) {
                String nom = rs.getString("nom");
                clm = new ClubModele(id, nom);

                return clm;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    //*************************** C CREATE *************************************
    
    /**
     * 
     * @param clm
     * @throws Exception 
     */
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
