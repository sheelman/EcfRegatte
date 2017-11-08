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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "regatte")
@XmlRootElement
public class Regatte implements Serializable {

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
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "lieu")
    private String lieu;
    @Basic(optional = false)
    @Column(name = "numero_course")
    private short numeroCourse;
    @Basic(optional = false)
    @Column(name = "distance")
    private long distance;
    @JoinColumn(name = "id_challenge", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Challenge idChallenge;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegatte")
    private Collection<Enregistrer> enregistrerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegatte")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegatte")
    private Collection<Pointe> pointeCollection;

    public Regatte() {
    }

    public Regatte(Integer id) {
        this.id = id;
    }

    public Regatte(Integer id, String nom, Date date, String lieu, short numeroCourse, long distance) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.numeroCourse = numeroCourse;
        this.distance = distance;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public short getNumeroCourse() {
        return numeroCourse;
    }

    public void setNumeroCourse(short numeroCourse) {
        this.numeroCourse = numeroCourse;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public Challenge getIdChallenge() {
        return idChallenge;
    }

    public void setIdChallenge(Challenge idChallenge) {
        this.idChallenge = idChallenge;
    }

    @XmlTransient
    public Collection<Enregistrer> getEnregistrerCollection() {
        return enregistrerCollection;
    }

    public void setEnregistrerCollection(Collection<Enregistrer> enregistrerCollection) {
        this.enregistrerCollection = enregistrerCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<Pointe> getPointeCollection() {
        return pointeCollection;
    }

    public void setPointeCollection(Collection<Pointe> pointeCollection) {
        this.pointeCollection = pointeCollection;
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
        if (!(object instanceof Regatte)) {
            return false;
        }
        Regatte other = (Regatte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdg3.DAO.Regatte[ id=" + id + " ]";
    }
    
}
