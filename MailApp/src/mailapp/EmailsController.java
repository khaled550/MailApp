/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;

/**
 * FXML Controller class
 *
 * @author khaled
 */
public class EmailsController implements Initializable {

    public static int curPos = -1;
    
    @FXML
    private JFXListView<Label> emailsListView;

    @FXML
    private JFXButton sendMailBtn;

    @FXML
    private JFXButton logoutBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Label mail = new Label("Mails");
        emailsListView.getItems().add(mail);
        
        for (int i = 0, n = FXMLDocumentController.messages.length; i < n; i++) {
            try {
                emailsListView.getItems().add(new Label(FXMLDocumentController.messages[i].getSubject()));
            } catch (MessagingException ex) {
                Logger.getLogger(EmailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
        emailsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            curPos = emailsListView.getSelectionModel().getSelectedIndex();
            
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("EmailContent.fxml"));
                Stage stage = new Stage();
            stage.setTitle("Email Content");
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EmailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
            
    }
    
    @FXML
    void sendMail(MouseEvent event) {
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("SendMail.fxml"));
                Stage stage = new Stage();
            stage.setTitle("Send Mail");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EmailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
