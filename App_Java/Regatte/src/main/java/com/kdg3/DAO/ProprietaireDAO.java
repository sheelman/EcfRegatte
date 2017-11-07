/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import com.kdg3.modele.ClubModele;
import com.kdg3.modele.PersonneModele;
import com.kdg3.modele.ProprietaireModele;
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
public class ProprietaireDAO {
    //**************************** R READ  ************************************
    
     /**
     * retourne la liste proprietaire
     *
     * @return
     * @throws java.sql.SQLException
     */
    
    public static List<ProprietaireModele> findAll() throws SQLException {

        Connection c = JDBConnect.getConnection();

        List<ProprietaireModele> ListProprietaires = new ArrayList<>();
        Statement stm;
        
        try {
            stm = c.createStatement();

            String sql = "select * from proprietaire INNER JOIN personne";
            ResultSet rs = stm.executeQuery(sql);
            
                while (rs.next()) {
                    int id = rs.getInt("id");
                    PersonneModele pem = PersonneDAO.findOnedById(rs.getInt("id_personne"));
                    ClubModele club = ClubDAO.findOnedById(rs.getInt("id_club"));
                    
                    ProprietaireModele prm = new ProprietaireModele(id, club, pem.getId(), pem.getNom(), pem.getPrenom(), pem.getAdresse(), pem.getCode_postal(), pem.getVille(), pem.getTelephone(), pem.getEmail(), pem.getDate_naissance(), pem.isAffilie_FFV(), pem.getNumero_licence(), pem.getDate_licence());
                                        
                    ListProprietaires.add(prm);
                }
                
                rs.close();
                return ListProprietaires;
                
        }catch(SQLException ex) {
            Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public static ProprietaireModele findOnedById(int id) {
        
            PersonneModele pem;
            ClubModele clm;
            ProprietaireModele prm = null;
            Connection c = JDBConnect.getConnection();
            Statement stm;
            
        try {   
            stm = c.createStatement();
            
            String sql="select * from proprietaire WHERE id="+id;
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                pem = PersonneDAO.findOnedById(rs.getInt("id_personne"));
                clm = ClubDAO.findOnedById(rs.getInt("id_club"));
                
                prm = new ProprietaireModele(id, clm, pem.getId(), pem.getNom(), pem.getPrenom(), pem.getAdresse(), pem.getCode_postal(), pem.getVille(), pem.getTelephone(), pem.getEmail(), pem.getDate_naissance(), pem.isAffilie_FFV(), pem.getNumero_licence(), pem.getDate_licence());
               
                return prm;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public static ProprietaireModele findByPersonneId(int personneId) {
        
            PersonneModele pem = PersonneDAO.findOnedById(personneId);
            ClubModele clm;
            ProprietaireModele prm = null;
            Connection c = JDBConnect.getConnection();
            Statement stm;
            
        try {   
            stm = c.createStatement();
            
            String sql="select * from proprietaire WHERE id_serie="+personneId;
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                int id = rs.getInt("id");
                clm = ClubDAO.findOnedById(rs.getInt("id_club"));
                
                
                prm = new ProprietaireModele(id, clm, pem.getId(), pem.getNom(), pem.getPrenom(), pem.getAdresse(), pem.getCode_postal(), pem.getVille(), pem.getTelephone(), pem.getEmail(), pem.getDate_naissance(), pem.isAffilie_FFV(), pem.getNumero_licence(), pem.getDate_licence());
               
                return prm;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public static ProprietaireModele findByClubId(int clubId) {
        
            ClubModele clm = ClubDAO.findOnedById(clubId);
            PersonneModele pem;
            ProprietaireModele prm = null;
            Connection c = JDBConnect.getConnection();
            Statement stm;
            
        try {   
            stm = c.createStatement();
            
            String sql="select * from proprietaire WHERE id_serie="+clubId;
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                int id = rs.getInt("id");
                pem = PersonneDAO.findOnedById(rs.getInt("id_personne"));
                
                
                prm = new ProprietaireModele(id, clm, pem.getId(), pem.getNom(), pem.getPrenom(), pem.getAdresse(), pem.getCode_postal(), pem.getVille(), pem.getTelephone(), pem.getEmail(), pem.getDate_naissance(), pem.isAffilie_FFV(), pem.getNumero_licence(), pem.getDate_licence());
               
                return prm;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }

    //*************************** C CREATE *************************************

    /**
     * CRUD
     * @param prm
     * @throws java.lang.Exception
     */
    public static void create(ProprietaireModele prm) throws Exception {

        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO proprietaire (id_personne, id_club) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
        stm.setInt(1, prm.getId_personne());
        stm.setInt(2, prm.getClub().getId());

        stm.execute();
        ResultSet rs = stm.getGeneratedKeys();

        if (rs.next()) {
            prm.setId(rs.getInt(1));
        }
        
        stm.close();
    }
    
    //***************************** U UPDATE ***********************************
    public static void update(ProprietaireModele prm) throws Exception {
        
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("UPDATE proprietaire SET id_personne = ? WHERE id = ?");
            stm.setInt(1, prm.getId_personne());
            stm.setInt(2, prm.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("pb lors de la mise a jour de proprietaire:" + e.getMessage());
        }
    }
    
    //**************************** D DELETE ************************************
    public static void delete(ProprietaireModele prm) throws Exception {
        
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("DELETE FROM proprietaire WHERE id = ?");
            stm.setInt(1, prm.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("pb lors de la suppression de proprietaire:" + e.getMessage());
        }
    }
}
