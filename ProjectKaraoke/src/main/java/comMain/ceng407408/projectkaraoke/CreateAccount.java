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
import static comMain.ceng407408.projectkaraoke.DeleteUser.stage;
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

/**
 *
 * @author sevtap
 */
public class CreateAccount implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static Stage stage = new Stage();
    @FXML
    public TextField nameGUI = new TextField();
    @FXML
    public TextField surnameGUI = new TextField();
    @FXML
    public TextField mailGUI = new TextField();
    @FXML
    public PasswordField passwordGUI = new PasswordField();
    @FXML
    public Button addGUI = new Button();
    @FXML
    public Button ppageGUI = new Button();
    @FXML
    public Button logout = new Button();
    @FXML
    public Label messageGUI = new Label();
    @FXML
    public Label nameMessage = new Label();
    @FXML
    public Label surnameMessage = new Label();
    @FXML
    public Label mailMessage = new Label();
    @FXML
    public Label passwordMessage = new Label();

    @FXML
    public void AddUser() {
        Karaoke db = new Karaoke();

        String Name = "";
        String Surname = "";
        String Mail = "";
        String Password = "";
        int passwordnumeric = 0;

        Name = nameGUI.getText();
        Surname = surnameGUI.getText();
        Mail = mailGUI.getText();
        Password = passwordGUI.getText().trim();
        passwordnumeric = Integer.parseInt(Password);

        System.out.println("ejfle" + Password);
        if (nameGUI.getText().isEmpty() == true) {
            nameMessage.setVisible(true);
            nameMessage.setText("Please Enter Name!");
        } else {
            nameMessage.setVisible(false);

        }

        if (surnameGUI.getText().isEmpty() == true) {

            surnameMessage.setVisible(true);
            surnameMessage.setText("Please Enter Surname!");

        } else {
            surnameMessage.setVisible(false);

        }
        if (mailGUI.getText().isEmpty() == true) {

            mailMessage.setVisible(true);
            mailMessage.setText("Please Enter Mail!");

        } else {
            mailMessage.setVisible(false);
        }
        if (passwordGUI.getText().trim().equals(" ")) {

            passwordMessage.setVisible(true);
            passwordMessage.setText("Please Enter Password!");

        } else {
            passwordMessage.setVisible(false);

        }

        if (!passwordGUI.getText().trim().equals("") && !mailGUI.getText().isEmpty() && !surnameGUI.getText().isEmpty() && !nameGUI.getText().isEmpty()) {

            int result = db.CreateUser(Name, Surname, Mail, passwordnumeric);

            if (result == 1) {
                messageGUI.setText("User Inserted Successfully!");
                messageGUI.setVisible(true);
            } else if (result == 2) {
                messageGUI.setText("There Is User In Database With " + Mail + " Mail Address!");
                messageGUI.setVisible(true);
            } else if (result == 0) {
                messageGUI.setText("User Cannot Inserted!");
                messageGUI.setVisible(true);

            }
        }

    }

    @FXML
    public void ppageBtn() {

        try {
            replaceSceneContent("/fxml/DeleteUser.fxml", 463, 339);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logoutBtn() {
        try {
            replaceSceneContent("/fxml/Login.fxml", 500, 350);
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
        stage.setScene(page.getScene());
        stage.setResizable(false);
        stage.setTitle("");
        stage.show();
        return page;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
