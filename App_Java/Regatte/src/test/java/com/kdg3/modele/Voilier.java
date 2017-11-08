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
@Table(name = "voilier")
@XmlRootElement
public class Voilier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_voile")
    private short numeroVoile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoilier")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proprietaire idProprietaire;
    @JoinColumn(name = "id_classe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classe idClasse;

    public Voilier() {
    }

    public Voilier(Integer id) {
        this.id = id;
    }

    public Voilier(Integer id, short numeroVoile) {
        this.id = id;
        this.numeroVoile = numeroVoile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getNumeroVoile() {
        return numeroVoile;
    }

    public void setNumeroVoile(short numeroVoile) {
        this.numeroVoile = numeroVoile;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Proprietaire getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Proprietaire idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
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
        if (!(object instanceof Voilier)) {
            return false;
        }
        Voilier other = (Voilier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdg3.DAO.Voilier[ id=" + id + " ]";
    }
    
}
