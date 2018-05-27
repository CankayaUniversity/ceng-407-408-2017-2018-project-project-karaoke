package comMain.ceng407408.projectkaraoke;

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

/*import org.fredy.jsrt.api.SRT;
import org.fredy.jsrt.api.SRTInfo;
import org.fredy.jsrt.api.SRTReader;
import org.fredy.jsrt.api.SRTTimeFormat;*/
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.PasswordField;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.event.ChangeListener;
import sun.applet.Main;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage stage = new Stage();
    @FXML
    public TextField mailGUI = new TextField();
    @FXML
    public PasswordField passwordGUI = new PasswordField();
    @FXML
    public Button loginButton = new Button();
    @FXML
    public Label messageGUI = new Label();
Parent root;
    /*@FXML
    public MediaView mediaT = new MediaView();*/
    @Override
    public void start(Stage stage) throws Exception {
        /*root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));

        Karaoke db = new Karaoke();
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styles.css");

        //Setting title of the login page 
        stage.setTitle("Login Page");
        loginButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        //Setting the scene
        stage.setScene(scene);

        //In order to block resizing the page(scene) 
        stage.setResizable(false);
        stage.show();*/
        replaceSceneContent("/fxml/Login.fxml", 500, 350);
    }

    @FXML
    public void loginBtn() throws Exception {

        Karaoke db = new Karaoke();

        String checkMail = "";
        String checkPassword = "";
        String strPathOfScene = "";
        int passwordnumeric;

        checkMail = mailGUI.getText();
        checkPassword = passwordGUI.getText().trim();
        passwordnumeric = Integer.parseInt(checkPassword);
        int result = db.Login(checkMail, passwordnumeric);
        System.out.println(passwordnumeric);
        System.out.println(checkMail);
        if (result == 1) {
            switch (UserSession.numUserType) {
                case 1:
                    strPathOfScene = "/fxml/AdminMainPage.fxml";
                    replaceSceneContent(strPathOfScene, 631, 316);
                    break;
                case 2:
                    strPathOfScene = "";
                    break;
                case 3:
                    strPathOfScene = "/fxml/UserMain.fxml";
                    replaceSceneContent(strPathOfScene, 600, 471);
                    break;
            }
        } else if (result == 2) {
            messageGUI.setText("User Is Not Active!");
            messageGUI.setVisible(true);
        } else if (result == 0) {
            messageGUI.setText("Wrong Mail or Password!");
            messageGUI.setVisible(true);

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
}
