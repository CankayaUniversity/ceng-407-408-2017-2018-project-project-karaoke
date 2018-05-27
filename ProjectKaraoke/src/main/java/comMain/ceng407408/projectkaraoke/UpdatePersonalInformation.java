/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

public class UpdatePersonalInformation implements Initializable {

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
    public Label messageGUI = new Label();
    @FXML
    public Button updatebtnGUI = new Button();
    @FXML
    public Button backbtnGUI = new Button();
    @FXML
    public Label nameMessage = new Label();
    @FXML
    public Label surnameMessage = new Label();
    @FXML
    public Label mailMessage = new Label();
    @FXML
    public Label passwordMessage = new Label();

    @Override

    public void initialize(URL location, ResourceBundle resources) {

        Karaoke db = new Karaoke();

        UserPersonalInformation result;

        String Password = "";
        int passwordnumeric = 0;

        result = db.GetUserInformation();
        nameGUI.setText(result.GetName());
        surnameGUI.setText(result.GetSurname());
        mailGUI.setText(result.GetMail());
        passwordnumeric = result.GetPassword();
        passwordGUI.setText(Password.valueOf(passwordnumeric));

    }

    @FXML
    public void updateBtn() {
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

            int result = db.UpdatePersonalInformation(Name, Surname, Mail, passwordnumeric);

            if (result == 1) {
                messageGUI.setText("User Updated Successfully!");
                messageGUI.setVisible(true);
            } else if (result == 0) {
                messageGUI.setText("User Cannot Updated!");
                messageGUI.setVisible(true);

            }
        }
    }

    @FXML
    public void backBtn() throws Exception {
        replaceSceneContent("/fxml/UserMain.fxml", 600, 471);
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
