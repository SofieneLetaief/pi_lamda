/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitest.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
public class page1Controller implements Initializable {

    @FXML
    private AnchorPane mainmoviespane;
    @FXML
    private AnchorPane leftpane;
    @FXML
    private JFXButton homebtn;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton moviescreensbtn;
    @FXML
    private JFXButton logoutbtn;
    @FXML
    private Label userlabel;
    @FXML
    private AnchorPane toppane;
    @FXML
    private JFXButton minimisebtn;
    @FXML
    private JFXButton closebtn;
    @FXML
    private AnchorPane tablepane;
    @FXML
    private AnchorPane SCREEN3;
    @FXML
    private AnchorPane SCREEN2;
    @FXML
    private AnchorPane SCREEN1;
    @FXML
    private AnchorPane SLOT1;
    @FXML
    private AnchorPane slot1shadow;
    @FXML
    private AnchorPane SLOT2;
    @FXML
    private AnchorPane slot2shadow;
    @FXML
    private AnchorPane SLOT4;
    @FXML
    private AnchorPane slot4shadow;
    @FXML
    private AnchorPane SLOT3;
    @FXML
    private AnchorPane slot3shadow;
    @FXML
    private AnchorPane moviepane;
    @FXML
    private ImageView movieimage;
    @FXML
    private JFXTextField searchfield;
    @FXML
    private JFXButton searchicon;
    @FXML
    private FontAwesomeIconView icon;
    @FXML
    private JFXButton allschedulesbtn;
    @FXML
    private Label movietitle;
    @FXML
    private Label movierating;
    @FXML
    private Label movieduration;
    @FXML
    private Label movierepeats;
    @FXML
    private Label movieticketsold;
    @FXML
    private JFXButton issueticketbtn;
    @FXML
    private JFXButton detailsbtn;

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
    private void logOut(ActionEvent event) {
    }

    @FXML
    private void minimiseWindow(ActionEvent event) {
    }

    @FXML
    private void handleClose(ActionEvent event) {
    }

    @FXML
    private void tileExit(MouseEvent event) {
    }

    @FXML
    private void tileHover(MouseEvent event) {
    }

    @FXML
    private void showAllSchedule(ActionEvent event) {
    }

    @FXML
    private void issueTicket(ActionEvent event) {
    }
    
}
