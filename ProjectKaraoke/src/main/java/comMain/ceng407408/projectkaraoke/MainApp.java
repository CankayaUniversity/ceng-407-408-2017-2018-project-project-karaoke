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
import javafx.scene.control.PasswordField;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.applet.Main;


public class MainApp extends Application {
    
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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styles.css");
        
        //Setting title of the login page 
        stage.setTitle("Karaoke Login");
        
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
                replaceSceneContent("teacher.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            System.out.println("sample.MainApp.loginBtn()");
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
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
