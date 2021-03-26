/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.services;

import edu.lamda.entities.Evenement;
import edu.lamda.interfaces.Ievenement;
import edu.lamda.tools.Myconnexion;
import edu.lamda.tools.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author arfaoui
 */
public class ServiceEvenement implements Ievenement<Evenement> {

    @Override
    public void ajouterEvenement(Evenement ev) {
        try {

            String requete = "INSERT INTO evenement (nom, lieu , heure , nbpart )" + "values (? ,? ,? ,?  ) ";
            PreparedStatement pst = Myconnexion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, ev.getNom());
            pst.setString(2, ev.getLieu());
            pst.setString(3, ev.getHeure());
            pst.setInt(4, ev.getNbpart());
            pst.executeUpdate();
            System.out.println("evenement inserer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouterEvenementD(Evenement ev) {
        try {

            String requete = "INSERT INTO evenement (nom, lieu , heure , nbpart , date )" + "values (? ,? ,? ,? ,?  ) ";
            PreparedStatement pst = Myconnexion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, ev.getNom());
            pst.setString(2, ev.getLieu());
            pst.setString(3, ev.getHeure());
            pst.setInt(4, ev.getNbpart());
            pst.setDate(5, ev.getDate());
            pst.executeUpdate();
    
            Notification.notificationPopUp("Evenement Ajouté", "" , "SUCCESS");
        } catch (SQLException ex) {
         Notification.notificationPopUp("Problème D'ajout  ", "", "FAIL");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerEvenementParId(int ide) {
        try {
            String requete = "DELETE FROM lamda.`evenement`where id=?";
            PreparedStatement pst = Myconnexion.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, ide);
            pst.executeUpdate();
            System.out.println("evenement supprimée");
               Notification.notificationPopUp("evenement Supprimer", "evenement num : " + ide, "SUCCESS");
        } catch (SQLException ex) {
             Notification.notificationPopUp("Problème De Suppression ", "evenement num : " + ide, "FAIL");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerEvenementParNom(String nom) {
        try {
            String requete = "DELETE FROM lamda.`evenement`where nom=?";
            PreparedStatement pst = Myconnexion.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, nom);
            pst.executeUpdate();
            System.out.println("Personne supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerEvenementTerminer() {
        try {
            String requete = "DELETE  FROM lamda.`evenement` WHERE date < NOW()";
            PreparedStatement pst = Myconnexion.getInstance().getCnx()
                    .prepareStatement(requete);

            pst.executeUpdate();
            System.out.println(" les produit terminé ont ete supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifierEvenement(int ide, Evenement ev) {
        try {
            String requete = "UPDATE evenement SET nom=? ,  lieu =? , heure=? , nbpart=?,date=?  WHERE id=?";
            PreparedStatement pst = Myconnexion.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, ev.getNom());
            pst.setString(2, ev.getLieu());
            pst.setString(3, ev.getHeure());
            pst.setInt(4, ev.getNbpart());
            pst.setDate(5, ev.getDate());
            pst.setInt(6, ide);
            pst.executeUpdate();
          Notification.notificationPopUp("Article Modifier", "Evenement num : " + ide, "SUCCESS");
        } catch (SQLException ex) {
          Notification.notificationPopUp("Probleme de modification", "Evenement num : " + ide, "FAIL");
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifierEvenement2(int ide, String nom, String lieu, String heure, int nbpart) {
        try {
            String requete = "UPDATE evenement SET nom=? ,  lieu =? , heure=? , nbpart=?  WHERE id=?";
            PreparedStatement pst = Myconnexion.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, nom);
            pst.setString(2, lieu);
            pst.setString(3, heure);
            pst.setInt(4, nbpart);
            pst.setInt(5, ide);

            pst.executeUpdate();
            System.out.println("Personne modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifierPersonneAvecDate(int ide, String nom, String lieu, String heure, int nbpart, Date date) {
        try {
            String requete = "UPDATE evenement SET nom=? ,  lieu =? , heure=? , nbpart=? , date = ? WHERE id=?";
            PreparedStatement pst = Myconnexion.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, nom);
            pst.setString(2, lieu);
            pst.setString(3, heure);
            pst.setInt(4, nbpart);
            pst.setDate(5, (java.sql.Date) date);
            pst.setInt(6, ide);

            pst.executeUpdate();
            System.out.println("Personne modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Evenement> listEvenement() {
        List<Evenement> listEvenement = new ArrayList<>();
        try {
            //supprimerEvenementTerminer();
            String requete = "SELECT * FROM evenement";
            Statement st = Myconnexion.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Evenement ev = new Evenement();
                ev.setId(rs.getInt("id"));
                ev.setNom(rs.getString("nom"));
                ev.setLieu(rs.getString("lieu"));
                ev.setHeure(rs.getString("heure"));
                ev.setNbpart(rs.getInt("nbpart"));
                ev.setDate(rs.getDate("date"));
                listEvenement.add(ev);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listEvenement;

    }

    @Override
    public List<Evenement> chercherParNom(String nom) {

        List<Evenement> listEvenement = new ArrayList<>();
        try {
            //asupprimerEvenementTerminer();
            String requete = "SELECT * FROM evenement WHERE nom= '" + nom + "'";
            Statement st = Myconnexion.getInstance().getCnx()
                    .createStatement();
            // PreparedStatement pst = MyConnextion.getInstance().getCnx()
            // .prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Evenement ev = new Evenement();
                ev.setId(rs.getInt("id"));
                ev.setNom(rs.getString(2));
                ev.setLieu(rs.getString(3));
                ev.setNbpart(rs.getInt("nbpart"));
                // pst.setString(1, nom);
                ev.setDate(rs.getDate("date"));
                listEvenement.add(ev);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (listEvenement.isEmpty()) {
            System.out.println("événements n'existe pas");

        }
        return listEvenement;
    }

    @Override
    public List<Evenement> chercherParid(int id) {

        List<Evenement> listEvenement = new ArrayList<>();
        try {
            //supprimerEvenementTerminer();
            String requete = "SELECT * FROM evenement WHERE id= '" + id + "'";
            Statement st = Myconnexion.getInstance().getCnx()
                    .createStatement();
            // PreparedStatement pst = MyConnextion.getInstance().getCnx()
            // .prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Evenement ev = new Evenement();
                ev.setId(rs.getInt("id"));
                ev.setNom(rs.getString(2));
                ev.setLieu(rs.getString(3));
                ev.setNbpart(rs.getInt("nbpart"));
                // pst.setString(1, nom);
                ev.setDate(rs.getDate("date"));
                listEvenement.add(ev);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (listEvenement.isEmpty()) {
            System.out.println("événements n'existe pas");

        }
        return listEvenement;
    }

    @Override
    public List<Evenement> triEvenementParNom() {
        List<Evenement> listEvenement = new ArrayList<>();
        try {
            String requete = "SELECT * FROM evenement ORDER BY nom";
            Statement st = Myconnexion.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Evenement ev = new Evenement();
                ev.setId(rs.getInt("id"));
                ev.setNom(rs.getString(2));
                ev.setLieu(rs.getString(3));
                ev.setNbpart(rs.getInt("nbpart"));
                ev.setDate(rs.getDate("date"));
                listEvenement.add(ev);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listEvenement;
    }

    @Override
    public List<Evenement> triEvenementParNbpart() {
        List<Evenement> listEvenement = new ArrayList<>();
        try {
            supprimerEvenementTerminer();
            String requete = "SELECT * FROM evenement ORDER BY nbpart ";
            Statement st = Myconnexion.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Evenement ev = new Evenement();
                ev.setId(rs.getInt("id"));
                ev.setNom(rs.getString(2));
                ev.setLieu(rs.getString(3));
                ev.setNbpart(rs.getInt("nbpart"));
                ev.setDate(rs.getDate("date"));
                listEvenement.add(ev);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listEvenement;
    }

    @Override
    public List<Evenement> triEvenementParDate() {
        List<Evenement> listEvenement = new ArrayList<>();
        try {
            supprimerEvenementTerminer();
            String requete = "SELECT * FROM evenement ORDER BY date ";
            Statement st = Myconnexion.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Evenement ev = new Evenement();
                ev.setId(rs.getInt("id"));
                ev.setNom(rs.getString(2));
                ev.setLieu(rs.getString(3));
                ev.setNbpart(rs.getInt("nbpart"));
                ev.setDate(rs.getDate("date"));
                listEvenement.add(ev);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listEvenement;
    }

}
