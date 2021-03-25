/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author arfaoui
 */
public class Evenement {
    private int id;
    private String nom;
    private String lieu;
    private String heure;
    private int nbpart;
    private Date date;
  

    public Evenement() {
    }

    public Evenement(int id, String nom, String lieu, String heure, int nbpart  ) {
        this.id = id;
        this.nom = nom;
        this.lieu = lieu;
        this.heure = heure;
        this.nbpart = nbpart;
        //this.date=date;
        
    }

    public Evenement(String nom, String lieu, String heure, int nbpart ) {
        this.nom = nom;
        this.lieu = lieu;
        this.heure = heure;
        this.nbpart = nbpart;
        //this.date=date;
       
                
    }
    //nouveau construct
       public Evenement(String nom, String lieu, String heure, int nbpart,Date date ) {
        this.nom = nom;
        this.lieu = lieu;
        this.heure = heure;
        this.nbpart = nbpart;
        this.date=date;
       
                
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public String getHeure() {
        return heure;
    }

    public int getNbpart() {
        return nbpart;
    }

   

   

  
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setNbpart(int nbpart) {
        this.nbpart = nbpart;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", nom=" + nom + ", lieu=" + lieu + ", heure=" + heure + ", nbpart=" + nbpart + ", date=" + date + '}';
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }
    
}
