/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.vue2;

import com.kdg3.DAO.PersonneDAO;
import com.kdg3.DAO.ProprietaireDAO;
import com.kdg3.modele.PersonneModele;
import com.kdg3.modele.ProprietaireModele;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sheelman
 */
public class CreationProprietaire extends javax.swing.JDialog {

    /**
     * Creates new form CreationProprietaire
     * @param parent
     * @param modal
     */
    public CreationProprietaire(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    CreationProprietaire(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("regatteTest?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        clubQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Club c");
        clubList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clubQuery.getResultList();
        jBtnFermer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextNom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCheckAffilie_FFV = new javax.swing.JCheckBox();
        jTextCode_postal = new javax.swing.JTextField();
        jTextAdresse = new javax.swing.JTextField();
        jTextVille = new javax.swing.JTextField();
        jTextTelephone = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jTextNumero_licence = new javax.swing.JTextField();
        jTextPrenom = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboClub = new javax.swing.JComboBox<>();
        jBtnAnnuler = new javax.swing.JButton();
        jBtnAjouterProprietaire = new javax.swing.JButton();
        jFormattedTextDate_naissance = new javax.swing.JFormattedTextField();
        jFormattedTextDate_licence = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnFermer.setText("FERMER");
        jBtnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFermerActionPerformed(evt);
            }
        });

        jLabel1.setText("Prénom");

        jLabel2.setText("Nom");

        jLabel3.setText("Affilié FFV");

        jLabel4.setText("Email");

        jLabel5.setText("Numero de licence");

        jLabel6.setText("Adresse");

        jLabel7.setText("Telephone");

        jLabel8.setText("Code postal");

        jLabel9.setText("Ville");

        jLabel10.setText("Date de naissance");

        jLabel11.setText("Date de licence");

        jCheckAffilie_FFV.setText("Licencié");
        jCheckAffilie_FFV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAffilie_FFVActionPerformed(evt);
            }
        });

        jLabel12.setText("Club");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clubList, jComboClub);
        bindingGroup.addBinding(jComboBoxBinding);

        jBtnAnnuler.setText("Annuler");

        jBtnAjouterProprietaire.setText("Ajouter le propiétaire");
        jBtnAjouterProprietaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjouterProprietaireActionPerformed(evt);
            }
        });

        try {
            jFormattedTextDate_naissance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextDate_naissance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextDate_naissance.setText("  /     /  ");
        jFormattedTextDate_naissance.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N

        try {
            jFormattedTextDate_licence.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextDate_licence.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextDate_licence.setText("  /       /  ");
        jFormattedTextDate_licence.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextDate_licence))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextNumero_licence))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextDate_naissance))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextEmail))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextTelephone))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextVille))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextCode_postal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextAdresse))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextPrenom))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextNom))
                    .addComponent(jBtnFermer, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckAffilie_FFV))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboClub, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnAjouterProprietaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnFermer)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextCode_postal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jFormattedTextDate_naissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCheckAffilie_FFV))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextNumero_licence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jFormattedTextDate_licence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAnnuler)
                    .addComponent(jBtnAjouterProprietaire))
                .addGap(24, 24, 24))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFermerActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBtnFermerActionPerformed

    private void jCheckAffilie_FFVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAffilie_FFVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckAffilie_FFVActionPerformed

    private void jBtnAjouterProprietaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAjouterProprietaireActionPerformed
        
            String nom = jTextNom.getText();
            String prenom = jTextPrenom.getText();
            String adresse = jTextAdresse.getText();
            String code_postal = jTextCode_postal.getText();
            String ville = jTextVille.getText();
            String telephone = jTextTelephone.getText();
            String email = jTextEmail.getText();
            Date date_naissance = jFormattedTextDate_naissance.getText();
            Boolean affilie_FFV = jCheckAffilie_FFV.getText();
            String numero_licence = jTextNumero_licence.getText();
            Date date_licence = jFormattedTextDate_licence.getText();
            Club club = (Club) jComboClub.getSelectedItem();
            if(nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || code_postal.isEmpty()|| ville.isEmpty()||telephone.isEmpty()||email.isEmpty()|| date_naissance.isEmpty()|| numero_licence.isEmpty()|| date_licence.isEmpty() ){
                JOptionPane jop;
                jop=new JOptionPane();
                jop.showMessageDialog(null,
                        "INFORMATION MANQUANTE!!!!!",
                        " warning",JOptionPane.WARNING_MESSAGE);
            }else{
                try {
                    PersonneModele personne = new PersonneModele(0, nom, prenom, adresse, code_postal, ville, telephone, email, date_naissance, affilie_FFV, numero_licence, date_licence);
                    
                    int personneId = PersonneDAO.create(personne);
                    
                    personne.setId(personneId);
                    ProprietaireModele proprietaire = new ProprietaireModele(0, club, personne.getId(), personne.getNom(), personne.getPrenom(), personne.getAdresse(), personne.getCode_postal(), personne.getVille(), personne.getTelephone(), personne.getEmail(), personne.getDate_naissance(), personne.isAffilie_FFV(), personne.getNumero_licence(), personne.getDate_licence());
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

    }//GEN-LAST:event_jBtnAjouterProprietaireActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreationProprietaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationProprietaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationProprietaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationProprietaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreationProprietaire dialog = new CreationProprietaire(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<com.kdg3.vue2.Club> clubList;
    private javax.persistence.Query clubQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jBtnAjouterProprietaire;
    private javax.swing.JButton jBtnAnnuler;
    private javax.swing.JButton jBtnFermer;
    private javax.swing.JCheckBox jCheckAffilie_FFV;
    private javax.swing.JComboBox<String> jComboClub;
    private javax.swing.JFormattedTextField jFormattedTextDate_licence;
    private javax.swing.JFormattedTextField jFormattedTextDate_naissance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextAdresse;
    private javax.swing.JTextField jTextCode_postal;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNom;
    private javax.swing.JTextField jTextNumero_licence;
    private javax.swing.JTextField jTextPrenom;
    private javax.swing.JTextField jTextTelephone;
    private javax.swing.JTextField jTextVille;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
