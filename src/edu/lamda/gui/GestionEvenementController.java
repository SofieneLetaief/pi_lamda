/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.lamda.entities.Evenement;
import edu.lamda.services.ServiceEvenement;
import edu.lamda.tools.Myconnexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Letaief Sofiene
 */
public class GestionEvenementController implements Initializable {

    @FXML
    private AnchorPane selectPane;
    @FXML
    private Label errorlabel;
    @FXML
    private TableColumn<Evenement , Integer> tvId;
    @FXML
    private TableColumn<Evenement , String> tvNom;
    @FXML
    private TableColumn<Evenement , String> tvLieu;
    @FXML
    private TableColumn<Evenement , String> tvHeure;
    @FXML
    private TableColumn<Evenement , Integer> tvNbpart;
    @FXML
    private TableColumn<Evenement , Date> tvDate;
    @FXML
    private FontAwesomeIconView bnRefresh;
    @FXML
    private JFXButton cancelbtn;
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
    @FXML
    private AnchorPane toppane;
    @FXML
    private JFXButton minimisebtn;
    @FXML
    private JFXButton closebtn;
    @FXML
    private TableView<Evenement> TableV;

    /**
     * Initializes the controller class.
     */
    
       ServiceEvenement se = new ServiceEvenement();
    @FXML
    private JFXButton addBtn;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXButton deleteBtn;
       
       
    int idCurrentUpdatedEvent;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadDataEvent();
     
     deleteBtn.setDisable(true);
     updateBtn.setDisable(true);
       TableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                    System.out.println(newValue);
                 populateInputs((Evenement) newValue);

        });
    }    


    @FXML
    private void ajouteEvent(ActionEvent event) {
          String nom = nomTf.getText();
        String lieu = lieuTf.getText();
        String heure = heureTf.getText();
        int nbpart = Integer.parseInt(nombreTf.getText()); 
 
       
        java.sql.Date date = java.sql.Date.valueOf(datePicker.getValue());
        
        Evenement e = new Evenement(nom, lieu, heure, nbpart, date);

       

        se.ajouterEvenementD(e);
        
        refreshTable(null);
        
         reset(null);
      
        
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        
         String nom = nomTf.getText();
        String lieu = lieuTf.getText();
        String heure = heureTf.getText();
        int nbpart = Integer.parseInt(nombreTf.getText()); 
 
       
        java.sql.Date date = java.sql.Date.valueOf(datePicker.getValue());
        
        Evenement e = new Evenement(nom, lieu, heure, nbpart, date);
        
        se.modifierEvenement(idCurrentUpdatedEvent, e);

         refreshTable(null);
         
         reset(null);
      
        
    }

    @FXML
    private void minimiseWindow(ActionEvent event) {
    }

    @FXML
    private void handleClose(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
 
     public void loadDataEvent(){
    //        ObservableList<Evenement> list=  loadEvenement();   
           ObservableList list = FXCollections.observableArrayList();
          list.addAll(se.listEvenement());
  
         tvId.setCellValueFactory(new PropertyValueFactory<Evenement , Integer>("Id"));
         tvNom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("nom"));
          tvDate.setCellValueFactory(new PropertyValueFactory<Evenement, Date>("date"));
        
        
        tvLieu.setCellValueFactory(new PropertyValueFactory<Evenement, String>("lieu") );
        tvHeure.setCellValueFactory(new PropertyValueFactory<Evenement, String>("heure") );
        tvNbpart.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("nbpart") );
        

         TableV.setItems(list);
 
    }  

    @FXML
    private void refreshTable(MouseEvent event) {
        
           ObservableList list = FXCollections.observableArrayList();
           list.addAll(se.listEvenement());
        
          TableV.setItems(list);
         
    }

    


    @FXML
    private void reset(ActionEvent event) {
         nomTf.setText("");

        lieuTf.setText("");

        heureTf.setText("");
        
        datePicker.setValue(null);


        nombreTf.setText("");
        

        updateBtn.setDisable(true);
        deleteBtn.setDisable(true);
          
      //  updateEvent.setDisable(true);
//
//     AddEvent;
//     updateEvent;
//     nomTf;
//     lieuTf;
//     datePicker;
//     heureTf;
//     nombreTf;
    }
    
   public void  populateInputs(Evenement evenement){
       
          nomTf.setText(evenement.getNom());

         lieuTf.setText(evenement.getLieu());
 
         heureTf.setText(evenement.getHeure());
        
         datePicker.setValue(evenement.getDate().toLocalDate());


         nombreTf.setText(String.valueOf(evenement.getNbpart()));
          
        updateBtn.setDisable(false);
        deleteBtn.setDisable(false);
    
   
   }

    @FXML
    private void deleteEvent(ActionEvent event) {
        
        se.supprimerEvenementParId(idCurrentUpdatedEvent);
        
        
    }
    

   
          public void notificationPopUp(String title, String Message, String typeNotification) {
          TrayNotification tray = new TrayNotification();
          AnimationType type = AnimationType.POPUP;

        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(Message);
        if (typeNotification.equals("SUCCESS")) {
            tray.setNotificationType(NotificationType.SUCCESS);
        } else {

            tray.setNotificationType(NotificationType.ERROR);
        }
        tray.showAndDismiss(Duration.millis(3000));
    }
}
