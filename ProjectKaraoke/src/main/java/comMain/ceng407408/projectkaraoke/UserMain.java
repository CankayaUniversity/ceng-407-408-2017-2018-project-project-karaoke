/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import UserStatic.UserSession;
import static comMain.ceng407408.projectkaraoke.MainApp.stage;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author mehmetali
 */
public class UserMain implements Initializable {

    private final Karaoke objMainFunc = new Karaoke();
    @FXML
    TableView<UserAbst> tableviewListOfSingers = new TableView<UserAbst>();
    @FXML
    Button buttonScoreTable = new Button();
    @FXML
    Button buttonAddStudent = new Button();
    @FXML
    Button buttonStartKaraoke = new Button();
    @FXML
    Button update = new Button();
    @FXML
    Button logout = new Button();

    @FXML
    public void funcScoreTable() throws SQLException, Exception {
        replaceSceneContent("/fxml/ScoreTable.fxml", 600, 400);
    }

    @FXML
    public void funcAddStudent() throws Exception {
        replaceSceneContent("/fxml/AddStudent.fxml", 600, 400);
    }

    @FXML
    public void funcStartKaroke() throws Exception {
        replaceSceneContent("/fxml/KaraokeSongSinger.fxml", 311, 226);
    }

    @FXML
    public void updateBtn() throws Exception {
        replaceSceneContent("/fxml/UpdatePersonalInformation.fxml", 600, 400);
    }

    @FXML
    public void logoutBtn() throws Exception {
        UserSession.numUserId = -1;
        replaceSceneContent("/fxml/Login.fxml", 500, 350);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            objMainFunc.funcListSinger(tableviewListOfSingers);
        } catch (SQLException ex) {
            Logger.getLogger(UserMain.class.getName()).log(Level.SEVERE, null, ex);
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
