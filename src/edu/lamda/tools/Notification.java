/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lamda.tools;

import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author Letaief Sofiene
 */
public class Notification {
    
    
  static   public void notificationPopUp(String title, String Message, String typeNotification) {
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
