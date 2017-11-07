/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import com.kdg3.modele.ClasseModele;
import com.kdg3.modele.ProprietaireModele;
import com.kdg3.modele.VoilierModele;
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
public class VoilierDAO {
    //**************************** R READ  ************************************
    
     /**
     * retourne la liste voilier
     *
     * @return
     * @throws java.sql.SQLException
     */
    
    public static List<VoilierModele> findAll() throws SQLException {

        Connection c = JDBConnect.getConnection();

        List<VoilierModele> ListVoiliers = new ArrayList<>();
        Statement stm;
        
        try {
            stm = c.createStatement();

            String sql = "select * from voilier";
            ResultSet rs = stm.executeQuery(sql);
            
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int numero_voile = rs.getInt("numero_voile");
                    ProprietaireModele id_proprietaire = ProprietaireDAO.findOnedById(rs.getInt("id_proprietaire"));
                    ClasseModele id_classe = ClasseDAO.findOnedById(rs.getInt("id_classe"));
                    
                    VoilierModele vlm = new VoilierModele(id, numero_voile, id_proprietaire, id_classe);
                                        
                    ListVoiliers.add(vlm);
                }
                
                rs.close();
                return ListVoiliers;
                
        }catch(SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public static VoilierModele findOnedById(int id) {
        
            ProprietaireModele prm;
            ClasseModele clam;
            VoilierModele vlm = null;
            Connection c = JDBConnect.getConnection();
            Statement stm;
            
        try {   
            stm = c.createStatement();
            
            String sql="select * from voilier WHERE id="+id;
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                int numero_voile = rs.getInt("numero_voile");
                prm = ProprietaireDAO.findOnedById(rs.getInt("id_proprietaire"));
                clam = ClasseDAO.findOnedById(rs.getInt("id_classe"));
                
                vlm = new VoilierModele(id, numero_voile, prm, clam);
               
                return vlm;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public static VoilierModele findByProprietaireId(int proprietaireId) {
        
            ProprietaireModele prm = ProprietaireDAO.findOnedById(proprietaireId);
            ClasseModele clam;
            VoilierModele vlm = null;
            Connection c = JDBConnect.getConnection();
            Statement stm;
            
        try {   
            stm = c.createStatement();
            
            String sql="select * from voilier WHERE id_proprietaire="+proprietaireId;
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                int id = rs.getInt("id");
                int numero_voile = rs.getInt("numero_voile");
                clam = ClasseDAO.findOnedById(rs.getInt("id_classe"));
                
                
                vlm = new VoilierModele(id, numero_voile, prm, clam);
               
                return vlm;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public static VoilierModele findByClasseId(int classeId) {
        
            ClasseModele clam = ClasseDAO.findOnedById(classeId);
            ProprietaireModele prm;
            VoilierModele vlm = null;
            Connection c = JDBConnect.getConnection();
            Statement stm;
            
        try {   
            stm = c.createStatement();
            
            String sql="select * from voilier WHERE id_classe="+classeId;
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                int id = rs.getInt("id");
                int numero_voile = rs.getInt("numero_voile");
                prm = ProprietaireDAO.findOnedById(rs.getInt("id_proprietaire"));
                
                
                vlm = new VoilierModele(id, numero_voile, prm, clam);
               
                return vlm;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }

    //*************************** C CREATE *************************************

    /**
     * CRUD
     * @param vlm
     * @throws java.lang.Exception
     */
    public static void create(VoilierModele vlm) throws Exception {

        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO voilier (numero_voile, id_proprietaire, id_classe) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        stm.setInt(1, vlm.getNumero_voile());
        stm.setInt(2, vlm.getProprietaire().getId());
        stm.setInt(3, vlm.getClasse().getId());

        stm.execute();
        ResultSet rs = stm.getGeneratedKeys();

        if (rs.next()) {
            vlm.setId(rs.getInt(1));
        }
        
        stm.close();
    }
    
    //***************************** U UPDATE ***********************************
    public static void update(VoilierModele vlm) throws Exception {
        
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("UPDATE voilier SET numero_voile = ? WHERE id = ?");
            stm.setInt(1, vlm.getNumero_voile());
            stm.setInt(2, vlm.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("pb lors de la mise a jour de voilier:" + e.getMessage());
        }
    }
    
    //**************************** D DELETE ************************************
    public static void delete(VoilierModele vlm) throws Exception {
        
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("DELETE FROM voilier WHERE id = ?");
            stm.setInt(1, vlm.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("pb lors de la suppression de voilier:" + e.getMessage());
        }
    }
}
