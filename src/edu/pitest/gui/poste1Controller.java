/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitest.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Letaief Sofiene
 */
public class poste1Controller implements Initializable {

    @FXML
    private AnchorPane mainpane;
    @FXML
    private AnchorPane leftpane;
    @FXML
    private Label userlabel;
    @FXML
    private JFXButton homebtn;
    @FXML
    private JFXButton addbtn;
    @FXML
    private AnchorPane selectPane;
    @FXML
    private JFXButton cancelbtn;
    @FXML
    private Label ticketPriceLabel;
    @FXML
    private Label errorlabel;
    @FXML
    private JFXCheckBox checkbox;
    @FXML
    private JFXButton sharebtn;
    @FXML
    private JFXTextField titlefield;
    @FXML
    private JFXTextArea subjectfield;
    @FXML
    private Label datelabel;
    @FXML
    private Label timelabel;
    @FXML
    private JFXComboBox<?> groupeCombo;
    @FXML
    private JFXButton loeadbtn;
    @FXML
    private JFXTextField imagefield;
    @FXML
    private ImageView selectedimage;
    @FXML
    private AnchorPane toppane;
    @FXML
    private JFXButton minimisebtn;
    @FXML
    private JFXButton closebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnExit(MouseEvent event) {
    }

    @FXML
    private void btnHover(MouseEvent event) {
    }

    @FXML
    private void loadScene(ActionEvent event) {
    }

    @FXML
    private void AjouterPoste(ActionEvent event) {
    }

    @FXML
    private void selectGroupe(ActionEvent event) {
    }

    @FXML
    private void handleButtons(ActionEvent event) {
    }

    @FXML
    private void minimiseWindow(ActionEvent event) {
    }

    @FXML
    private void handleClose(ActionEvent event) {
    }
    
}
