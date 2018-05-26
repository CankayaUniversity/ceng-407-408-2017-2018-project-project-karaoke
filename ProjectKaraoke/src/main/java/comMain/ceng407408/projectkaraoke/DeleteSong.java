/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import static comMain.ceng407408.projectkaraoke.MainApp.stage;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 *
 * @author mehmetali
 */
public class DeleteSong implements Initializable {

    @FXML
    Button buttonDelete = new Button();
    @FXML
    Button buttonBack = new Button();
    @FXML
    Label labelMessage = new Label();
    @FXML
    TableView<SongProperties> tableviewSongs = new TableView<>();
    private Karaoke objMainFunc = new Karaoke();
    private int numDeleteID = -1;

    private Parent replaceSceneContent(String fxml) throws Exception {

        Parent page = (Parent) FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
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
    public void funcDelete() {
        if (numDeleteID >= 0) {
            int numFlag = objMainFunc.DeleteSong(numDeleteID);
            switch (numFlag) {
                case 0:
                    labelMessage.setText("Something gone wrong!");
                    break;
                default:
                    labelMessage.setText("Selected song deleted successfully!");
                    break;
            }
        } else {
            labelMessage.setText("You have to select a song!");
        }
    }

    @FXML
    public void funcBack() throws Exception {
        replaceSceneContent("/fxml/AdminMainPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            objMainFunc.funcListSong(tableviewSongs);
            tableviewSongs.getSelectionModel().selectedItemProperty().addListener(new javafx.beans.value.ChangeListener<SongProperties>() {
                @Override
                public void changed(ObservableValue<? extends SongProperties> obs, SongProperties oldV, SongProperties newV) {
                    numDeleteID = newV.getNumSongID();
                }
            });
        } catch (Exception exExc) {

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
