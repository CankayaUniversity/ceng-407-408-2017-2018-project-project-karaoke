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
    private static Main instance;
    @FXML
    public TextField mailGUI =  new TextField();

    @FXML
    public TextField passwordGUI= new TextField();

    @FXML
    public MediaView mediaT = new MediaView();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getClass().getResource("/fxml/Login.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styles.css");
        
        //Setting title of the login page 
        stage.setTitle("Login");
        
        //Setting the scene
        stage.setScene(scene);
        
        //In order to block resizing the page(scene) 
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void loginBtn() {

        Karaoke db = new Karaoke();
        
        String checkMail = "";
        String checkPassword = "";
        int passwordnumeric;

        checkMail = mailGUI.getText();
        if(checkMail==null)
        {
            System.out.println("mali");
            return;
        }
            
        checkPassword = passwordGUI.getText().trim();
        passwordnumeric = Integer.parseInt(checkPassword);
        
        int result = db.Login(checkMail,passwordnumeric);

        if(result==1)
        {            
            try {
                replaceSceneContent("/fxml/teacher.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("comMain.MainApp.loginBtn()");
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
}
