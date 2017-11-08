/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg3.modele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sheelman
 */
@MappedSuperclass
@Table(name = "course")
@XmlRootElement
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_inscription_valide")
    private String numeroInscriptionValide;
    @Basic(optional = false)
    @Column(name = "nombre_point")
    private short nombrePoint;
    @Basic(optional = false)
    @Column(name = "temps_reel")
    @Temporal(TemporalType.TIME)
    private Date tempsReel;
    @Basic(optional = false)
    @Column(name = "position")
    private short position;
    @JoinColumn(name = "id_regatte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Regatte idRegatte;
    @JoinColumn(name = "id_voilier", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voilier idVoilier;
    @JoinColumn(name = "id_equipage", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipage idEquipage;
    @JoinColumn(name = "id_code", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Code idCode;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String numeroInscriptionValide, short nombrePoint, Date tempsReel, short position) {
        this.id = id;
        this.numeroInscriptionValide = numeroInscriptionValide;
        this.nombrePoint = nombrePoint;
        this.tempsReel = tempsReel;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroInscriptionValide() {
        return numeroInscriptionValide;
    }

    public void setNumeroInscriptionValide(String numeroInscriptionValide) {
        this.numeroInscriptionValide = numeroInscriptionValide;
    }

    public short getNombrePoint() {
        return nombrePoint;
    }

    public void setNombrePoint(short nombrePoint) {
        this.nombrePoint = nombrePoint;
    }

    public Date getTempsReel() {
        return tempsReel;
    }

    public void setTempsReel(Date tempsReel) {
        this.tempsReel = tempsReel;
    }

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    public Regatte getIdRegatte() {
        return idRegatte;
    }

    public void setIdRegatte(Regatte idRegatte) {
        this.idRegatte = idRegatte;
    }

    public Voilier getIdVoilier() {
        return idVoilier;
    }

    public void setIdVoilier(Voilier idVoilier) {
        this.idVoilier = idVoilier;
    }

    public Equipage getIdEquipage() {
        return idEquipage;
    }

    public void setIdEquipage(Equipage idEquipage) {
        this.idEquipage = idEquipage;
    }

    public Code getIdCode() {
        return idCode;
    }

    public void setIdCode(Code idCode) {
        this.idCode = idCode;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdg3.DAO.Course[ id=" + id + " ]";
    }
    
}
