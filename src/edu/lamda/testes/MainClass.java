/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.testes;

import edu.lamda.entities.Evenement;
import edu.lamda.services.ServiceEvenement;

/**
 *
 * @author arfaoui
 */
public class MainClass {

    public static void main(String[] args) {

        String str = "2021-08-03";
        java.sql.Date d = java.sql.Date.valueOf(str);

        Evenement e1 = new Evenement("foot", "beja", "11h", 24, d);

        ServiceEvenement se = new ServiceEvenement();

         se.ajouterEvenementD(e1);
        //System.out.println(se.chercherParNom("foot"));
        //System.out.println(se.chercherParid(3));
        //System.out.println(se.listEvenement());
        //se.modifierEvenement(4, e1);
        //se.supprimerEvenementParNom("foot");
    }

}
