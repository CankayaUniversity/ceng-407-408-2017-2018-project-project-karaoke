/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaMarkerEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import comMain.ceng407408.projectkaraoke.*;
import static comMain.ceng407408.projectkaraoke.MainApp.stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.event.ChangeListener;
import sun.applet.Main;
/**
 *
 * @author sevtap
 */
public class DeleteUser implements Initializable{
 @Override
     public void initialize(URL location, ResourceBundle resources){
       
}

 public static Stage stage = new Stage();
    @FXML public ListView listUsersGUI =  new ListView();
    @FXML public TextField deletedUserMailGUI= new TextField();
    @FXML public  Button deleteBtnGUI = new Button();
    @FXML public  Label messageGUI = new Label();
    
    @FXML
    public void DeleteBtn()
    {
        Karaoke db = new Karaoke();
        
        String Mail = "";
  
        Mail = deletedUserMailGUI.getText();
        System.out.println(Mail);
        int result = db.DeleteUser(Mail);

        if(result==1)
        {            
           messageGUI.setText("User Deleted Successfully!");
           messageGUI.setVisible(true);
        }
        else if(result==0)
        {
             messageGUI.setText("There Is User In Database With " + Mail + " Mail Address!");
             messageGUI.setVisible(true);
        }
        else if(result==2)
        {
            messageGUI.setText("User Is Not Active!");
            messageGUI.setVisible(true);
        
        }
            
        
    } 
     @FXML
    public void ppageBtn(){
  
         try {
                replaceSceneContent("/fxml/teacher.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
     @FXML
    public void logoutBtn()
    {
         try {
                replaceSceneContent("/fxml/Login.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
    } 
    
       private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page;
        page = (Parent) FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 600, 600);

            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        stage.show();
        return page;
 
                
    }   
       
     public static void main(String[] args) {
        launch(args);
    }
  
}
