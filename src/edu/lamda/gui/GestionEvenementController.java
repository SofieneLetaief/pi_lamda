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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     showreclamation();
    }    


    @FXML
    private void ajouteEvent(ActionEvent event) {
    }

    @FXML
    private void updateEvent(ActionEvent event) {
    }

    @FXML
    private void minimiseWindow(ActionEvent event) {
    }

    @FXML
    private void handleClose(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    
         public ObservableList<Evenement> loadEvenement(){
        ObservableList<Evenement> Evenementlist = FXCollections.observableArrayList();
        Connection conn = Myconnexion.getInstance().getCnx();
        String query = "select id, nom  , lieu, heure , nbpart from evenement ";
        
        Statement st;
        
        ResultSet rs;
        
        try{
            st= conn.createStatement();
            
            rs= st.executeQuery(query);
            
            Evenement event;
            while(rs.next() ){
                event = new Evenement(rs.getInt("id"),rs.getString("nom"),rs.getString("lieu"),rs.getString("heure"), rs.getInt("nbpart"));
                Evenementlist.add(event);
                
            }
          
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Evenementlist;
    }

   public void showreclamation(){
            ObservableList<Evenement> list=  loadEvenement();          
            
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
        
        ObservableList<Evenement> list=  loadEvenement();          
            
         tvId.setCellValueFactory(new PropertyValueFactory<Evenement , Integer>("Id"));
         tvNom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("nom"));
          tvDate.setCellValueFactory(new PropertyValueFactory<Evenement, Date>("date"));
        
        
        tvLieu.setCellValueFactory(new PropertyValueFactory<Evenement, String>("lieu") );
        tvHeure.setCellValueFactory(new PropertyValueFactory<Evenement, String>("heure") );
        tvNbpart.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("nbpart") );
        
        
         TableV.setItems(list);
         
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
