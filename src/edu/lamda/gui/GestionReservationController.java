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
import edu.lamda.services.ServiceReservation;
import edu.lamda.tools.CurrentSession;
import java.net.URL;
import java.sql.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Letaief Sofiene
 */
public class GestionReservationController implements Initializable {

    @FXML
    private AnchorPane selectPane;
    @FXML
    private Label errorlabel;
   @FXML
    private TableView<Evenement> TableV;
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
    private JFXTextField searchTf;
    @FXML
    private JFXTextField nombreTf;
    @FXML
    private AnchorPane toppane;
    @FXML
    private JFXButton minimisebtn;
    @FXML
    private JFXButton closebtn;

    /**
     * Initializes the controller class.
     */
    
         int idCurrentUpdatedEvent;
         int placeDispo=0;
     ServiceEvenement se = new ServiceEvenement();
       ServiceReservation sr = new ServiceReservation();
     ObservableList list = FXCollections.observableArrayList();
    @FXML
    private JFXButton reserveBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDataEvent();
         reserveBtn.setDisable(true);
         TableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          idCurrentUpdatedEvent=((Evenement) newValue).getId();
                    placeDispo=se.nombrePlaceDispo(((Evenement) newValue).getId());
                        System.out.println(placeDispo);
                          
           nombreTf.setText(String.valueOf(placeDispo));
           
           if(placeDispo<=0){
           reserveBtn.setDisable(true);
           }else{
           reserveBtn.setDisable(false);
           }
               }

        });
        
        
        //nombreTf1
    }    

  
  

    @FXML
    private void refreshTable(MouseEvent event) {
        
           list.clear();
           list.addAll(se.listEvenement());
        
          TableV.setItems(list);
         
    }

        
      @FXML
    private void filter(KeyEvent event) {
        list.clear();
        // System.out.println("heyy yuuu");
        list.addAll(se.listEvenement().stream().filter((evenement)
                -> evenement.getNom().toLowerCase().contains(searchTf.getText().toLowerCase())
                || evenement.getLieu().toLowerCase().contains(searchTf.getText().toLowerCase())
                || String.valueOf(evenement.getNbpart()).toLowerCase().contains(searchTf.getText().toLowerCase())
                || evenement.getHeure().toLowerCase().contains(searchTf.getText().toLowerCase())


        ).collect(Collectors.toList()));
    }      
         
    

    @FXML
    private void reserveEvent(ActionEvent event) {
        
        sr.ajouterReservation(idCurrentUpdatedEvent, CurrentSession.client.getId());
        
         nombreTf.setText(null);
         reserveBtn.setDisable(true);
         
          try {
                    String host = "smtp.gmail.com";
                    String user = "lamdaappdev@gmail.com";
                    String pass = "lamda123";
                    
                    String to = CurrentSession.client.getMail();
                    String from = "lamdaappdev@gmail.com";
                    String subject = "Your Reservation  Was Successfully Created";
                    String messageText = "Welcome " + "Mr." +  CurrentSession.client.getNom()+" " +CurrentSession.client.getPrenom();;

                    boolean sessionDebug = false;

                    Properties props = System.getProperties();

                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", host);
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.required", "true");

                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session mailSession = Session.getDefaultInstance(props, null);
                    mailSession.setDebug(sessionDebug);
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(from));
                    InternetAddress[] address = {new InternetAddress(to)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setSentDate(new java.util.Date());
                    msg.setText(messageText);

                    Transport transport = mailSession.getTransport("smtp");
                    transport.connect(host, user, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    System.out.println("message send successfully");
                } catch (Exception ex) {
                    System.out.println(ex);

                }
         
         
        
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
          list.clear();
          list.addAll(se.listEvenement());
  

         tvNom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("nom"));
          tvDate.setCellValueFactory(new PropertyValueFactory<Evenement, Date>("date"));
        
        
        tvLieu.setCellValueFactory(new PropertyValueFactory<Evenement, String>("lieu") );
        tvHeure.setCellValueFactory(new PropertyValueFactory<Evenement, String>("heure") );
        tvNbpart.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("nbpart") );
        

         TableV.setItems(list);
 
    }  
    
}
