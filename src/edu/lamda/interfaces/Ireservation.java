/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.interfaces;

import edu.lamda.entities.Evenement;
import java.util.List;

/**
 *
 * @author Letaief Sofiene
 */
public interface Ireservation <t>{
    
     public void ajouterReservation(int idEv,int idCl);

     public void supprimeReservationParId(int ide);

     public void modifierReservation(int ide, t ev);


     public List<t> listReservation();

//    public List<t> chercherParNom(String nom);
//
//    public List<t> triEvenementParNom();
//
//    public List<t> triEvenementParNbpart();
//
//    public List<t> chercherParid(int id);
//
//    public List<t> triEvenementParDate();
    
}
