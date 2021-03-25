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
 * @author arfaoui
 */
public interface Ievenement <t>{
    
     public void ajouterEvenement(t ev);

    public void ajouterEvenementD(Evenement ev);

    public void supprimerEvenementParId(int ide);

    public void supprimerEvenementParNom(String nom);

    public void supprimerEvenementTerminer();

    public void modifierEvenement(int ide, t ev);

    public void modifierEvenement2(int ide, String nom, String lieu, String heure, int nbpart);

    public List<t> listEvenement();

    public List<t> chercherParNom(String nom);

    public List<t> triEvenementParNom();

    public List<t> triEvenementParNbpart();

    public List<Evenement> chercherParid(int id);

    public List<Evenement> triEvenementParDate();
    
}
