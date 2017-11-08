/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.modele;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sheelman
 */
@MappedSuperclass
@Table(name = "personne")
@XmlRootElement
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "code_postal")
    private String codePostal;
    @Column(name = "ville")
    private String ville;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Basic(optional = false)
    @Column(name = "affilie_FFV")
    private boolean affilieFFV;
    @Column(name = "numero_licence")
    private String numeroLicence;
    @Column(name = "date_licence")
    @Temporal(TemporalType.DATE)
    private Date dateLicence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Commissaire> commissaireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Jury> juryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Skypper> skypperCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Concurent> concurentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Proprietaire> proprietaireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Personnel> personnelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Membres> membresCollection;

    public Personne() {
    }

    public Personne(Integer id) {
        this.id = id;
    }

    public Personne(Integer id, String nom, String prenom, boolean affilieFFV) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.affilieFFV = affilieFFV;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean getAffilieFFV() {
        return affilieFFV;
    }

    public void setAffilieFFV(boolean affilieFFV) {
        this.affilieFFV = affilieFFV;
    }

    public String getNumeroLicence() {
        return numeroLicence;
    }

    public void setNumeroLicence(String numeroLicence) {
        this.numeroLicence = numeroLicence;
    }

    public Date getDateLicence() {
        return dateLicence;
    }

    public void setDateLicence(Date dateLicence) {
        this.dateLicence = dateLicence;
    }

    @XmlTransient
    public Collection<Commissaire> getCommissaireCollection() {
        return commissaireCollection;
    }

    public void setCommissaireCollection(Collection<Commissaire> commissaireCollection) {
        this.commissaireCollection = commissaireCollection;
    }

    @XmlTransient
    public Collection<Jury> getJuryCollection() {
        return juryCollection;
    }

    public void setJuryCollection(Collection<Jury> juryCollection) {
        this.juryCollection = juryCollection;
    }

    @XmlTransient
    public Collection<Skypper> getSkypperCollection() {
        return skypperCollection;
    }

    public void setSkypperCollection(Collection<Skypper> skypperCollection) {
        this.skypperCollection = skypperCollection;
    }

    @XmlTransient
    public Collection<Concurent> getConcurentCollection() {
        return concurentCollection;
    }

    public void setConcurentCollection(Collection<Concurent> concurentCollection) {
        this.concurentCollection = concurentCollection;
    }

    @XmlTransient
    public Collection<Proprietaire> getProprietaireCollection() {
        return proprietaireCollection;
    }

    public void setProprietaireCollection(Collection<Proprietaire> proprietaireCollection) {
        this.proprietaireCollection = proprietaireCollection;
    }

    @XmlTransient
    public Collection<Personnel> getPersonnelCollection() {
        return personnelCollection;
    }

    public void setPersonnelCollection(Collection<Personnel> personnelCollection) {
        this.personnelCollection = personnelCollection;
    }

    @XmlTransient
    public Collection<Membres> getMembresCollection() {
        return membresCollection;
    }

    public void setMembresCollection(Collection<Membres> membresCollection) {
        this.membresCollection = membresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdg3.DAO.Personne[ id=" + id + " ]";
    }
    
}
