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
@Table(name = "personnel")
@XmlRootElement
public class Personnel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;

    public Personnel() {
    }

    public Personnel(Integer id) {
        this.id = id;
    }

    public Personnel(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
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
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdg3.DAO.Personnel[ id=" + id + " ]";
    }
    
}
