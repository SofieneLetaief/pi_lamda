/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.gui;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import edu.lamda.entities.Evenement;
import edu.lamda.services.ServiceEvenement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author arfaoui
 */
public class AjouterController implements Initializable {

    @FXML
    private JFXTextField tfNom;
    @FXML
    private JFXTextField tfLieu;
    @FXML
    private JFXTextField tfHeure;
    @FXML
    private JFXDatePicker tfDate;
    @FXML
    private JFXTextField tfNbPart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSave(MouseEvent event) {
        //int id = Integer.parseInt(tfId.getText());
        String nom = tfNom.getText();
        String lieu = tfLieu.getText();
        String heure = tfHeure.getText();
        int nbpart = Integer.parseInt(tfNbPart.getText()); 
        String str = "2021-08-03";
        java.sql.Date date = java.sql.Date.valueOf(str);
        
        Evenement e = new Evenement(nom, lieu, heure, nbpart, date);

        ServiceEvenement pcd = new ServiceEvenement();

        pcd.ajouterEvenementD(e);

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailles.fxml"));
//
//        try {
//            Parent root = loader.load();
//            DetaillesController dwc = loader.getController();
//            dwc.setTextId("" + p.getId());
//            dwc.setTextNom(p.getNom());
//            dwc.setTextPrenom(prenom);
//            tfNom.getScene().setRoot(root);
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }

    }

    @FXML
    private void btncancel(MouseEvent event) {
    }
    
}
