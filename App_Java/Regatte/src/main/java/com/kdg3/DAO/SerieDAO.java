/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import com.kdg3.modele.SerieModele;
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
public class SerieDAO {
    //**************************** R READ  *************************************
     /**
     * retourne la liste club
     *
     * @return
     */
    
    public static List<SerieModele> findAll() throws SQLException {

        Connection c = JDBConnect.getConnection();

        List<SerieModele> ListSeries = new ArrayList<>();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from serie";
            ResultSet rs = stm.executeQuery(sql);
            
                while (rs.next()) {
                    int id = rs.getInt("serie.id");
                    String nom = rs.getString("serie.nom");
                    
                    SerieModele sem = new SerieModele(id, nom);
                                        
                    ListSeries.add(sem);
                }
                rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ListSeries;
    }

    public static SerieModele findOnedById(int id) {
        
        SerieModele sem = null;
        Connection c = JDBConnect.getConnection();
        Statement stm;
        
        try {
            stm = c.createStatement();
            
            String sql="select * from serie WHERE id_serie="+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()) {
                String nom = rs.getString("serie.nom");
                sem = new SerieModele(id, nom);
            }
            
        } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException();
        }

        return sem;
    }
    
    /**
    *CRUD
    *
    */
    //*************************** C CREATE *************************************
    public static void create(SerieModele sem) throws Exception {

        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO serie (nom) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, sem.getNom());

        stm.execute();
        ResultSet rs = stm.getGeneratedKeys();

        if (rs.next()) {
            sem.setId(rs.getInt(1));
        }
        stm.close();
    }
    
    //***************************** U UPDATE ***********************************
    public static void update(SerieModele sem) throws Exception {
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("UPDATE serie SET nom = ? WHERE id = ?");
            stm.setString(1, sem.getNom());
            stm.setInt(2, sem.getId());

            stm.executeUpdate();

        } catch (SQLException e) {

            throw new Exception("pb lors de la mise a jour de serie:" + e.getMessage());
        }
    }
    
    //**************************** D DELETE ************************************
    public static void delete(SerieModele sem) throws Exception {
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("DELETE FROM serie WHERE id = ?");
            stm.setInt(1, sem.getId());

            stm.executeUpdate();

        } catch (SQLException e) {

            throw new Exception("pb lors de la suppression de serie:" + e.getMessage());
        }
    }
}
