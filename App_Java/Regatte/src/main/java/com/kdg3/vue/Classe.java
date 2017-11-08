/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.vue;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author sheelman
 */
@Entity
@Table(name = "classe", catalog = "regatteTest", schema = "")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c")
    , @NamedQuery(name = "Classe.findById", query = "SELECT c FROM Classe c WHERE c.id = :id")
    , @NamedQuery(name = "Classe.findByNom", query = "SELECT c FROM Classe c WHERE c.nom = :nom")
    , @NamedQuery(name = "Classe.findByCoefficient", query = "SELECT c FROM Classe c WHERE c.coefficient = :coefficient")
    , @NamedQuery(name = "Classe.findByIdSerie", query = "SELECT c FROM Classe c WHERE c.idSerie = :idSerie")})
public class Classe implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
    @Column(name = "coefficient")
    private float coefficient;
    @Basic(optional = false)
    @Column(name = "id_serie")
    private int idSerie;

    public Classe() {
    }

    public Classe(Integer id) {
        this.id = id;
    }

    public Classe(Integer id, String nom, float coefficient, int idSerie) {
        this.id = id;
        this.nom = nom;
        this.coefficient = coefficient;
        this.idSerie = idSerie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        changeSupport.firePropertyChange("nom", oldNom, nom);
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        float oldCoefficient = this.coefficient;
        this.coefficient = coefficient;
        changeSupport.firePropertyChange("coefficient", oldCoefficient, coefficient);
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        int oldIdSerie = this.idSerie;
        this.idSerie = idSerie;
        changeSupport.firePropertyChange("idSerie", oldIdSerie, idSerie);
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
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
