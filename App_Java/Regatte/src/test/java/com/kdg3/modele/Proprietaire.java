/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.modele;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sheelman
 */
@MappedSuperclass
@Table(name = "proprietaire")
@XmlRootElement
public class Proprietaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;
    @JoinColumn(name = "id_club", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Club idClub;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProprietaire")
    private Collection<Voilier> voilierCollection;

    public Proprietaire() {
    }

    public Proprietaire(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Club getIdClub() {
        return idClub;
    }

    public void setIdClub(Club idClub) {
        this.idClub = idClub;
    }

    @XmlTransient
    public Collection<Voilier> getVoilierCollection() {
        return voilierCollection;
    }

    public void setVoilierCollection(Collection<Voilier> voilierCollection) {
        this.voilierCollection = voilierCollection;
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
        return "com.kdg3.DAO.Proprietaire[ id=" + id + " ]";
    }
    
}
