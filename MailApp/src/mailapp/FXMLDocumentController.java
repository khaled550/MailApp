/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapp;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.Properties;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

/**
 *
 * @author khaled
 */
public class FXMLDocumentController implements Initializable {
    
    public static final ObservableList data = 
        FXCollections.observableArrayList();
    
    public static String user = "";
    public static String pass = "";
    
    public static Message[] messages;
    
    @FXML
    private JFXComboBox<String> mailSelection;
    
    @FXML
    private JFXTextField emailTxt;

    @FXML
    private JFXPasswordField passTxt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        mailSelection.getItems().add("Gmail");
        //mailSelection.getItems().add("Yahoo");
        
        
    }
    
    @FXML
    void login(ActionEvent event) throws java.io.IOException {
        
        int selected = mailSelection.getSelectionModel().getSelectedIndex();
        user = emailTxt.getText();
        pass = passTxt.getText();
        boolean logged = true;
        
        if(emailTxt.getText().isEmpty() || passTxt.getText().isEmpty())
             return;
        
        if(selected == 0){
            logged = check("pop.gmail.com", "pop3", user, pass);
            
        if(logged)
        {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("Emails.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Emails");
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } else {
            
        }
    }
    }
    
    
    public static boolean check(String host, String storeType, String user,String password) 
   {
      try {

      //create properties field
      Properties properties = new Properties();

      properties.put("mail.pop3.host", host);
      properties.put("mail.pop3.port", "995");
      properties.put("mail.pop3.starttls.enable", "true");
      Session emailSession = Session.getDefaultInstance(properties);
  
      //create the POP3 store object and connect with the pop server
      Store store = emailSession.getStore("pop3s");

      store.connect(host, user, password);

      //create the folder object and open it
      Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_ONLY);

      // retrieve the messages from the folder in an array and print it
      messages = emailFolder.getMessages();
      System.out.println("messages.length---" + messages.length);

      ObservableList<String> messagesList =FXCollections.observableArrayList ();
      
      for (int i = 0, n = messages.length; i < n; i++) {
         Message message = messages[i];
         System.out.println("Subject: " + message.getSubject());
      }

      //close the store and folder objects
      //emailFolder.close(false);
      //store.close();
      
      return true;
      } catch (NoSuchProviderException e) {
         e.printStackTrace();
         return false;
      } catch (MessagingException e) {
         e.printStackTrace();
         return false;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }
    
}
