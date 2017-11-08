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
@Table(name = "proprietaire", catalog = "regatteTest", schema = "")
@NamedQueries({
    @NamedQuery(name = "Proprietaire.findAll", query = "SELECT p FROM Proprietaire p")
    , @NamedQuery(name = "Proprietaire.findById", query = "SELECT p FROM Proprietaire p WHERE p.id = :id")
    , @NamedQuery(name = "Proprietaire.findByIdPersonne", query = "SELECT p FROM Proprietaire p WHERE p.idPersonne = :idPersonne")
    , @NamedQuery(name = "Proprietaire.findByIdClub", query = "SELECT p FROM Proprietaire p WHERE p.idClub = :idClub")})
public class Proprietaire implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_personne")
    private int idPersonne;
    @Basic(optional = false)
    @Column(name = "id_club")
    private int idClub;

    public Proprietaire() {
    }

    public Proprietaire(Integer id) {
        this.id = id;
    }

    public Proprietaire(Integer id, int idPersonne, int idClub) {
        this.id = id;
        this.idPersonne = idPersonne;
        this.idClub = idClub;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        int oldIdPersonne = this.idPersonne;
        this.idPersonne = idPersonne;
        changeSupport.firePropertyChange("idPersonne", oldIdPersonne, idPersonne);
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        int oldIdClub = this.idClub;
        this.idClub = idClub;
        changeSupport.firePropertyChange("idClub", oldIdClub, idClub);
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
        if (!(object instanceof Proprietaire)) {
            return false;
        }
        Proprietaire other = (Proprietaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
