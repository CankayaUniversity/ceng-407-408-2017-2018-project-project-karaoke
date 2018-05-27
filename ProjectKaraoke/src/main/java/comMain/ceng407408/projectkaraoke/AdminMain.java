/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

/**
 *
 * @author sevtap
 */
import UserStatic.UserSession;
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
import static comMain.ceng407408.projectkaraoke.CreateAccount.stage;
import static comMain.ceng407408.projectkaraoke.MainApp.stage;
//import static comMain.ceng407408.projectkaraoke.MainApp.stage;

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
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.event.ChangeListener;
import sun.applet.Main;

public class AdminMain implements Initializable{
    
      @Override
     public void initialize(URL location, ResourceBundle resources){
     }
     
    public static Stage stage = new Stage();
  
    @FXML public  Button addSongbtnGUI = new Button();
    @FXML public  Button deleteSongBtnGUI = new Button();
    @FXML public  Button createUserBtnGUI = new Button();
    @FXML public  Button deleteUserBtnGUI = new Button();
    @FXML public  Button logout = new Button();
    @FXML
    public void addSongBtn()
    {
        
         try {
                replaceSceneContent("/fxml/AddSong.fxml", 600, 400);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
      @FXML
    public void logoutBtn()
    {
        
         try {
                UserSession.numUserId=-1;
                replaceSceneContent("/fxml/Login.fxml", 500, 350);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    @FXML
    public void deleteSongBtn()
    {
          try {
                replaceSceneContent("/fxml/DeleteSong.fxml", 533, 365);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    @FXML
     public void createUserBtn()
    {
          try {
                replaceSceneContent("/fxml/AdminCreateAccount.fxml", 600, 400);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    @FXML
    public void deleteUserBtn()
    {
          try {
                replaceSceneContent("/fxml/DeleteUser.fxml", 463, 339);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
     private Parent replaceSceneContent(String fxml, int numX, int numY) throws Exception {
        Parent page;
        page = (Parent) FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, numX, numY);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }

        //stage.getScene().setRoot(page);
        //stage.setScene(page.getScene());
        stage.setMinHeight(numY);
        stage.setMinWidth(numX);
        stage.setMaxHeight(numY);
        stage.setMaxWidth(numX);
        stage.setResizable(false);
        stage.setTitle("");
        stage.show();
        return page;
    }
       
     public static void main(String[] args) {
        launch(args);
    }
}
