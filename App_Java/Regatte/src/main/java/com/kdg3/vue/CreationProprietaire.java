/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.vue;

import com.kdg3.DAO.ClubDAO;
import com.kdg3.DAO.PersonneDAO;
import com.kdg3.DAO.ProprietaireDAO;
import com.kdg3.modele.ClubModele;
import com.kdg3.modele.PersonneModele;
import com.kdg3.modele.ProprietaireModele;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sheelman
 */
public class CreationProprietaire extends javax.swing.JPanel {

    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    /**
     * Creates new form CreationProprietaire
     */
    public CreationProprietaire() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnFermer = new javax.swing.JButton();
        jLabelNom = new javax.swing.JLabel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelAdresse = new javax.swing.JLabel();
        jLabelCode_postal = new javax.swing.JLabel();
        jLabelVille = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jTextFieldAdresse = new javax.swing.JTextField();
        jTextFieldCode_postal = new javax.swing.JTextField();
        jTextFieldVille = new javax.swing.JTextField();
        jTextFieldTelephone = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldNumero_licence = new javax.swing.JTextField();
        jFormattedTextFieldDate_naissance = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDate_licence = new javax.swing.JFormattedTextField();
        jComboBoxClub = new javax.swing.JComboBox<>();
        jCheckBoxAffilie_FFV = new javax.swing.JCheckBox();
        jBtnAnnuler = new javax.swing.JButton();
        jBtnAjouter_proprietaire = new javax.swing.JButton();

        jBtnFermer.setText("FERMER");
        jBtnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFermerActionPerformed(evt);
            }
        });

        jLabelNom.setText("Nom");

        jLabelPrenom.setText("Prenom");

        jLabelAdresse.setText("Adresse");

        jLabelCode_postal.setText("Code_postal");

        jLabelVille.setText("Ville");

        jLabel6.setText("Téléphone");

        jLabel7.setText("Email");

        jLabel8.setText("Date de naissance");

        jLabel9.setText("Affilié FFV");

        jLabel10.setText("Numéro de licence");

        jLabel11.setText("Date de licence");

        jLabel12.setText("Club");

        jTextFieldTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelephoneActionPerformed(evt);
            }
        });

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldDate_naissance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDate_naissance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextFieldDate_naissance.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N

        try {
            jFormattedTextFieldDate_licence.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDate_licence.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextFieldDate_licence.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N

        jComboBoxClub.setModel(new javax.swing.DefaultComboBoxModel(ClubDAO.findAll().toArray()));

        jCheckBoxAffilie_FFV.setText("Licencié");

        jBtnAnnuler.setText("ANNULER");

        jBtnAjouter_proprietaire.setText("AJOUTER PROPRIETAIRE");
        jBtnAjouter_proprietaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjouter_proprietaireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnFermer, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBtnAnnuler, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVille, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelCode_postal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelAdresse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPrenom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxClub, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldDate_licence)
                            .addComponent(jTextFieldNumero_licence)
                            .addComponent(jFormattedTextFieldDate_naissance)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldTelephone)
                            .addComponent(jTextFieldVille)
                            .addComponent(jTextFieldCode_postal)
                            .addComponent(jTextFieldAdresse)
                            .addComponent(jTextFieldPrenom)
                            .addComponent(jTextFieldNom)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxAffilie_FFV)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jBtnAjouter_proprietaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnFermer)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNom)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrenom)
                    .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdresse)
                    .addComponent(jTextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCode_postal)
                    .addComponent(jTextFieldCode_postal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVille)
                    .addComponent(jTextFieldVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextFieldDate_naissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCheckBoxAffilie_FFV))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldNumero_licence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jFormattedTextFieldDate_licence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAnnuler)
                    .addComponent(jBtnAjouter_proprietaire))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelephoneActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jBtnAjouter_proprietaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAjouter_proprietaireActionPerformed
            //pour simplifier l'essai je n'utilise pas tous les champs
            String nom = jTextFieldNom.getText();
            String prenom = jTextFieldPrenom.getText();
//            String adresse = jTextFieldAdresse.getText();
//            String code_postal = jTextFieldCode_postal.getText();
//            String ville = jTextFieldVille.getText();
//            String telephone = jTextFieldTelephone.getText();
//            String email = jTextFieldEmail.getText();
//            String sdate_naissance = jFormattedTextFieldDate_naissance.getText();
//            String affilie_FFV = jCheckBoxAffilie_FFV.getText();
//            String numero_licence = jTextFieldNumero_licence.getText();
//            String sdate_licence = jFormattedTextFieldDate_licence.getText();
            ClubModele club = (ClubModele) jComboBoxClub.getSelectedItem();
            if(nom.isEmpty() || prenom.isEmpty()/* || adresse.isEmpty() || code_postal.isEmpty()|| ville.isEmpty()|| telephone.isEmpty()||email.isEmpty()|| sdate_naissance.isEmpty()|| numero_licence.isEmpty()|| sdate_licence.isEmpty()*/ ){
                JOptionPane jop;
                jop=new JOptionPane();
                jop.showMessageDialog(null,
                        "INFORMATION MANQUANTE!!!!!",
                        " warning",JOptionPane.WARNING_MESSAGE);
            }else{
                try {
//                    Date date_naissance = df.parse(sdate_naissance);
//                    Date date_licence = df.parse(sdate_licence);
//                    boolean affilie = Boolean.parseBoolean(affilie_FFV);
                    
                    
                    PersonneModele personne = new PersonneModele(0, nom, prenom/*, adresse, code_postal, ville, telephone, email, date_naissance, affilie, numero_licence, date_licence*/);
                    PersonneDAO.create(personne);
                    
              
                    ProprietaireModele proprietaire = new ProprietaireModele(0, club, personne.getId(), personne.getNom(), personne.getPrenom()/*, personne.getAdresse(), personne.getCode_postal(), personne.getVille(), personne.getTelephone(), personne.getEmail(), personne.getDate_naissance(), personne.isAffilie_FFV(), personne.getNumero_licence(), personne.getDate_licence()*/);
                    ProprietaireDAO.create(proprietaire);
                    
                    JOptionPane jop1;
                    jop1=new JOptionPane();
                    jop1.showMessageDialog(null,
                            "le proprietaire a été créé",
                            " Success",JOptionPane.INFORMATION_MESSAGE);
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(CreationProprietaire.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(CreationProprietaire.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }//GEN-LAST:event_jBtnAjouter_proprietaireActionPerformed

    private void jBtnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFermerActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBtnFermerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAjouter_proprietaire;
    private javax.swing.JButton jBtnAnnuler;
    private javax.swing.JButton jBtnFermer;
    private javax.swing.JCheckBox jCheckBoxAffilie_FFV;
    private javax.swing.JComboBox<String> jComboBoxClub;
    private javax.swing.JFormattedTextField jFormattedTextFieldDate_licence;
    private javax.swing.JFormattedTextField jFormattedTextFieldDate_naissance;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelCode_postal;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelVille;
    private javax.swing.JTextField jTextFieldAdresse;
    private javax.swing.JTextField jTextFieldCode_postal;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldNumero_licence;
    private javax.swing.JTextField jTextFieldPrenom;
    private javax.swing.JTextField jTextFieldTelephone;
    private javax.swing.JTextField jTextFieldVille;
    // End of variables declaration//GEN-END:variables
}
