/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.services;

import edu.lamda.entities.Evenement;
import edu.lamda.entities.Reservation;
import edu.lamda.interfaces.Ireservation;
import edu.lamda.tools.Myconnexion;
import edu.lamda.tools.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arfaoui
 */
public class ServiceReservation implements Ireservation<Reservation> {

    @Override
    public void ajouterReservation(int idEv, int idCl) {
               try {

            String requete = "INSERT INTO reservation (event_id, client_id  )" + "values (? ,? ) ";
            PreparedStatement pst = Myconnexion.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, idEv);
            pst.setInt(2, idCl);
            pst.executeUpdate();
            Notification.notificationPopUp("reservation Ajouté", "" , "SUCCESS");
        } catch (SQLException ex) {
         Notification.notificationPopUp("Problème reservation  ", "", "FAIL");
        }
    }

    @Override
    public void supprimeReservationParId(int ide) {
          try {
            String requete = "DELETE FROM lamda.`reservation` where id=?";
            PreparedStatement pst = Myconnexion.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, ide);
            pst.executeUpdate();
            System.out.println("reservation supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierReservation(int idr, Reservation reservation) {
            try {
            String requete = "UPDATE reservation SET event_id=?, client_id=? WHERE id=?";
            PreparedStatement pst = Myconnexion.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, reservation.getEvent_id());
            pst.setInt(2, reservation.getClient_id());
            pst.setInt(3, idr);
            pst.executeUpdate();
            System.out.println("reservation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public List<Reservation> listReservation() {
      List<Reservation> listReservation = new ArrayList<>();
        try {
            //supprimerEvenementTerminer();
            String requete = "SELECT * FROM reservation";
            Statement st = Myconnexion.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reservation ev = new Reservation();
                ev.setId(rs.getInt("id"));
                ev.setEvent_id(rs.getInt("event_id"));
                ev.setClient_id(rs.getInt("client_id"));
           
                listReservation.add(ev);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listReservation;

    }
    
    
    
}
