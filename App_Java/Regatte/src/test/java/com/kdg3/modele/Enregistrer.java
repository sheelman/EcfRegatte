/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.modele;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sheelman
 */
@MappedSuperclass
@Table(name = "enregistrer")
@XmlRootElement
public class Enregistrer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_jury", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Jury idJury;
    @JoinColumn(name = "id_regatte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Regatte idRegatte;

    public Enregistrer() {
    }

    public Enregistrer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jury getIdJury() {
        return idJury;
    }

    public void setIdJury(Jury idJury) {
        this.idJury = idJury;
    }

    public Regatte getIdRegatte() {
        return idRegatte;
    }

    public void setIdRegatte(Regatte idRegatte) {
        this.idRegatte = idRegatte;
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
        if (!(object instanceof Enregistrer)) {
            return false;
        }
        Enregistrer other = (Enregistrer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdg3.DAO.Enregistrer[ id=" + id + " ]";
    }
    
}
