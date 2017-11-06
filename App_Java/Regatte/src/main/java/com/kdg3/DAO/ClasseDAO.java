/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import com.kdg3.modele.ClasseModele;
import com.kdg3.modele.ClubModele;
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
public class ClasseDAO {
     //**************************** R READ  *************************************
     /**
     * retourne la liste club
     *
     * @return
     * @throws java.sql.SQLException
     */
    
    public static List<ClasseModele> findAllFromSerieID(int serieId) throws SQLException {

        Connection c = JDBConnect.getConnection();

        List<ClasseModele> ListClasses = new ArrayList<>();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from classe WHERE id_serie="+serieId;
            ResultSet rs = stm.executeQuery(sql);
            
                while (rs.next()) {
                    int id = rs.getInt("classe.id");
                    String nom = rs.getString("classe.nom");
                    Float coefficient = rs.getFloat("classe.coefficient");
                    SerieModele serie = SerieDAO.findOneById(serieId);;
                    
                    ClasseModele clam = new ClasseModele(id, nom, coefficient, serie);
                                        
                    ListClasses.add(clam);
                }
                rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ListClasses;
    }

    public static ClasseModele findOnedById(int id) {
        
        ClasseModele clam = null;
        Connection c = JDBConnect.getConnection();
        Statement stm;
        
        try {
            stm = c.createStatement();
            
            String sql="select * from classe WHERE club.id="+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()) {
                String nom = rs.getString("classe.nom");
                Float coefficient = rs.getFloat("classe.coefficient");
                serie = SerieDAO.findOneById(id_serie);
                
                clam = new ClasseModele(id, nom, coefficient, id_serie);
            }
            
        } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException();
        }

        return clam;
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
