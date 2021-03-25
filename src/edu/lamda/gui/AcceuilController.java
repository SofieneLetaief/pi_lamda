/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.lamda.entities.Evenement;
import edu.lamda.tools.Myconnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author arfaoui
 */
public class AcceuilController implements Initializable {

    @FXML
    private TableView<Evenement> TableV;
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
    private FontAwesomeIconView btnClose;
    @FXML
    private FontAwesomeIconView btnajouter;
    
    @FXML
    private TableColumn<?, ?> tvDate1;
    @FXML
    private FontAwesomeIconView bnRefresh;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        showreclamation();
        
    }    

    @FXML
    private void close(MouseEvent event) {
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void getAddView(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
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
