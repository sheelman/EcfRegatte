/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.DAO;

import com.kdg3.modele.PersonneModele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sheelman
 */
public class PersonneDAO {
    //**************************** R READ  *************************************
    
     /**
     * retourne la liste personne
     *
     * @return
     */
    
    public static List<PersonneModele> findAll() throws SQLException {

        Connection c = JDBConnect.getConnection();

        List<PersonneModele> ListPersonnes = new ArrayList<>();
        Statement stm;
        
        try {
            stm = c.createStatement();

            String sql = "select * from personne";
            ResultSet rs = stm.executeQuery(sql);
            
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String adresse = rs.getString("adresse");
                    String code_postal = rs.getString("code_postal");
                    String ville = rs.getString("ville");
                    String telephone = rs.getString("telephone");
                    String email = rs.getString("email");
                    Date date_naissance = rs.getDate("date_naissance");
                    Boolean affilie_FFV = rs.getBoolean("affilie_FFV");
                    String numero_licence = rs.getString("numero_licence");
                    Date date_licence = rs.getDate("date_licence");
                    
                    PersonneModele pem = new PersonneModele(id, nom, prenom, adresse, code_postal, ville, telephone, email, date_naissance, affilie_FFV, numero_licence, date_licence);
                                        
                    ListPersonnes.add(pem);
                }
                
                rs.close();
                return ListPersonnes;
                
        }catch(SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public static PersonneModele findOnedById(int id) {
        
        PersonneModele pem = null;
        Connection c = JDBConnect.getConnection();
        Statement stm;
        
        try {
            stm = c.createStatement();
            
            String sql="select * from personne WHERE id="+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                String code_postal = rs.getString("code_postal");
                String ville = rs.getString("ville");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                Date date_naissance = rs.getDate("date_naissance");
                Boolean affilie_FFV = rs.getBoolean("affilie_FFV");
                String numero_licence = rs.getString("numero_licence");
                Date date_licence = rs.getDate("date_licence");
                
                pem = new PersonneModele(id, nom, prenom, adresse, code_postal, ville, telephone, email, date_naissance, affilie_FFV, numero_licence, date_licence);
                      
                return pem;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //*************************** C CREATE *************************************
    
    /**
     * CRUD
     * 
     * @param pem
     * @throws Exception 
     */
    public static void create(PersonneModele pem) throws Exception {

        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO personne (nom, prenom, adresse, code_postal, ville, telephone, email, date_naissance, affilie_FFV, numero_licence, date_licence) VALUES (?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, pem.getNom());
        stm.setString(2, pem.getPrenom());
        stm.setString(3, pem.getAdresse());
        stm.setString(4, pem.getCode_postal());
        stm.setString(5, pem.getVille());
        stm.setString(6, pem.getTelephone());
        stm.setString(7, pem.getEmail());
        stm.setDate(8, (java.sql.Date) pem.getDate_naissance());
        stm.setBoolean(9, pem.isAffilie_FFV());
        stm.setString(10, pem.getNumero_licence());
        stm.setDate(11, (java.sql.Date) pem.getDate_licence());

        stm.execute();
        ResultSet rs = stm.getGeneratedKeys();

        if (rs.next()) {
            pem.setId(rs.getInt(1));
        }
        
        stm.close();
    }
    
    //***************************** U UPDATE ***********************************
    public static void update(PersonneModele pem) throws Exception {
        
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("UPDATE personne SET nom = ? WHERE id = ?");
            stm.setString(1, pem.getNom());
            stm.setInt(2, pem.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("pb lors de la mise a jour de personne:" + e.getMessage());
        }
    }
    
    //**************************** D DELETE ************************************
    public static void delete(PersonneModele pem) throws Exception {
        
        Connection c = JDBConnect.getConnection();
        PreparedStatement stm;
        
        try {
            stm = c.prepareStatement("DELETE FROM personne WHERE id = ?");
            stm.setInt(1, pem.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("pb lors de la suppression de personne:" + e.getMessage());
        }
    }
}
