/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import UserStatic.KaraokeCache;
import UserStatic.UserSession;
import static comMain.ceng407408.projectkaraoke.MainApp.stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author mehmetali
 */
public class KaraokeSongSinger implements Initializable {

    @FXML
    ChoiceBox choiceboxSingers = new ChoiceBox();
    @FXML
    ChoiceBox choiceboxSongs = new ChoiceBox();

    private Parent replaceSceneContent(String fxml) throws Exception {

        Parent page = (Parent) FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page,900,900);
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

    @FXML
    public void funcStart() throws Exception {
        try{
        if (KaraokeCache.numSingerID != 0 && KaraokeCache.numSongID != 0) {
            replaceSceneContent("/fxml/Karaoke.fxml");
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("You have to choose a song and a user!");
            alert.showAndWait();
        }
        }catch(Exception exExc){
            
        }
    }

    @FXML
    public void funcCancel() throws Exception {
        replaceSceneContent("/fxml/UserMain.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Karaoke objMainFunc = new Karaoke();
        ArrayList<SingerInfo> arrListSinger = objMainFunc.ViewSinger(UserSession.numUserId);
        ArrayList<SongProperties> arrListSongs = objMainFunc.ViewSongList();
        for (int i = 0; i < arrListSinger.size(); i++) {
            choiceboxSingers.getItems().add(FXCollections.observableArrayList(arrListSinger.get(i).getStrUserName()));
        }
        for (int i = 0; i < arrListSongs.size(); i++) {
            choiceboxSongs.getItems().add(FXCollections.observableArrayList(arrListSongs.get(i).getStrSongName()));
        }
        choiceboxSingers.getSelectionModel().selectedIndexProperty().addListener(
                (obs, oldV, newV) -> {
                    KaraokeCache.numSingerID = arrListSinger.get((int) newV).getNumID();
                }
        );
        choiceboxSongs.getSelectionModel().selectedIndexProperty().addListener(
                (obs, oldV, newV) -> {
                    KaraokeCache.numSongID = arrListSongs.get((int) newV).getNumSongID();
                }
        );
    }

    private static void main(String[] args) {
        launch(args);
    }
}
