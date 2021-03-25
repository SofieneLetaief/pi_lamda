/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arfaoui
 */
public class Myconnexion {
    
     String url="jdbc:mysql://localhost:3306/lamda";
    String login="root";
    String pwd="";
    Connection cnx;
    public static Myconnexion instance;

    private Myconnexion()  {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("connextion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(Myconnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Myconnexion getInstance()
    {
        if (instance == null){
            instance = new Myconnexion();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
