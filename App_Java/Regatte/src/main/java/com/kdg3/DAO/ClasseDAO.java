/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import com.kdg3.modele.ClasseModele;
import com.kdg3.modele.SerieModele;
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
public class ClasseDAO {
     //**************************** R READ  ************************************
    
     /**
     * retourne la liste classe
     *
     * @return
     * @throws java.sql.SQLException
     */
    
    public static List<ClasseModele> findAll() {

        Connection c = JDBConnect.getConnection();

        List<ClasseModele> ListClasses = new ArrayList<>();
        Statement stm;
        
        try {
            stm = c.createStatement();

            String sql = "select * from classe";
            ResultSet rs = stm.executeQuery(sql);
            
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    Float coefficient = rs.getFloat("coefficient");
                    SerieModele id_serie = SerieDAO.findOnedById(rs.getInt("id_serie"));
                    
                    ClasseModele clam = new ClasseModele(id, nom, coefficient, id_serie);
                                        
                    ListClasses.add(clam);
                }
                
                rs.close();
                return ListClasses;
                
        }catch(SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public static ClasseModele findOnedById(int id) {
        
            SerieModele sem;
            ClasseModele clam = null;
            Connection c = JDBConnect.getConnection();
            Statement stm;
            
        try {   
            stm = c.createStatement();
            
            String sql="select * from classe WHERE id="+id;
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                String nom = rs.getString("nom");
                Float coefficient = rs.getFloat("coefficient");
                sem = SerieDAO.findOnedById(rs.getInt("id_serie"));
                
                clam = new ClasseModele(id, nom, coefficient, sem);
               
                return clam;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public static ClasseModele findBySerieId(int serieId) {
        
            SerieModele sem = SerieDAO.findOnedById(serieId);
            ClasseModele clam = null;
            Connection c = JDBConnect.getConnection();
            Statement stm;
            
        try {   
            stm = c.createStatement();
            
            String sql="select * from classe WHERE id_serie="+serieId;
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                Float coefficient = rs.getFloat("coefficient");
                
                
                clam = new ClasseModele(id, nom, coefficient, sem);
               
                return clam;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }

    //*************************** C CREATE *************************************

    /**
     * CRUD
     * @param clm
     * @throws java.lang.Exception
     */
    public static void create(ClasseModele clam) throws Exception {

        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO club (nom, coefficient, id_serie) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, clam.getNom());
        stm.setFloat(2, clam.getCoefficient());
        stm.setInt(3, clam.getSerie().getId());

        stm.execute();
        ResultSet rs = stm.getGeneratedKeys();

        if (rs.next()) {
            clam.setId(rs.getInt(1));
        }
        
        stm.close();
    }
    
    //***************************** U UPDATE ***********************************
    public static void update(ClasseModele clam) throws Exception {
        
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("UPDATE club SET nom = ? WHERE id = ?");
            stm.setString(1, clam.getNom());
            stm.setInt(2, clam.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("pb lors de la mise a jour de classe:" + e.getMessage());
        }
    }
    
    //**************************** D DELETE ************************************
    public static void delete(ClasseModele clam) throws Exception {
        
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("DELETE FROM club WHERE id = ?");
            stm.setInt(1, clam.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("pb lors de la suppression de classe:" + e.getMessage());
        }
    }
}
