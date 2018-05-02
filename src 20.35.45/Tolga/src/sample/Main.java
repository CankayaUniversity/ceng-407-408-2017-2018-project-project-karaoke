package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
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
import org.fredy.jsrt.api.SRT;
import org.fredy.jsrt.api.SRTInfo;
import org.fredy.jsrt.api.SRTReader;
import org.fredy.jsrt.api.SRTTimeFormat;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Main extends Application {

    public static Stage stage;
    private static Main instance;

    public Main() {
        instance = this;
    }



    public static Main getInstance() {
        return instance;
    }
    @FXML
    public TextField userNameInput;



    @FXML
    public TextField passwordInput;

    @FXML
    public MediaView mediaT;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = primaryStage;
        primaryStage.setTitle("Karaoke");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();








    }



    @FXML
    public void loginPress() {


        String check1 = "";
        String check2 = "";

        check1 = userNameInput.getText();
        check2 = passwordInput.getText();


        if(check1.equals("Tolga") && check2.equals("1")) {

            try {
                replaceSceneContent("teacher.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }



        } else if(check1.equals("Ege") && check2.equals("2")) {

            try {
                replaceSceneContent("admin.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(check1.equals("Mehmet") && check2.equals("3")) {

            try {
                replaceSceneContent("familyUser.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }
    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());

        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 600, 600);

            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }








    public static void main(String[] args) {
        launch(args);
    }
}
