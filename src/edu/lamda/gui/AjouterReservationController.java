/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Letaief Sofiene
 */
public class AjouterReservationController implements Initializable {

    @FXML
    private AnchorPane selectPane;
    @FXML
    private JFXButton cancelbtn;
    @FXML
    private Label errorlabel;
    @FXML
    private AnchorPane toppane;
    @FXML
    private JFXButton minimisebtn;
    @FXML
    private JFXButton closebtn;
    @FXML
    private TableView<?> TableV;
    @FXML
    private TableColumn<?, ?> tvId;
    @FXML
    private TableColumn<?, ?> tvNom;
    @FXML
    private TableColumn<?, ?> tvLieu;
    @FXML
    private TableColumn<?, ?> tvHeure;
    @FXML
    private TableColumn<?, ?> tvNbpart;
    @FXML
    private TableColumn<?, ?> tvDate;
    @FXML
    private FontAwesomeIconView bnRefresh;
    @FXML
    private JFXButton AddEvent;
    @FXML
    private JFXButton updateEvent;
    @FXML
    private JFXTextField nomTf;
    @FXML
    private JFXTextField lieuTf;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField heureTf;
    @FXML
    private JFXTextField nombreTf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    




    
    
    
    
    
    
    
    
    
    @FXML
    private void minimiseWindow(ActionEvent event) {
    }

    @FXML
    private void handleClose(ActionEvent event) {
    }

    @FXML
    private void refreshTable(MouseEvent event) {
    }

    @FXML
    private void ajouteEvent(ActionEvent event) {
    }

    @FXML
    private void updateEvent(ActionEvent event) {
    }
    
}
