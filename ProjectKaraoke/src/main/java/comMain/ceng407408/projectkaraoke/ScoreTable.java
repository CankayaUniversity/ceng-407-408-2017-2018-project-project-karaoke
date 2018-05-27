/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import UserStatic.UserSession;
import static comMain.ceng407408.projectkaraoke.MainApp.stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TableView;
import javafx.scene.control.ChoiceBox;
import comMain.ceng407408.projectkaraoke.SingerInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javax.swing.event.ChangeListener;
import static jdk.nashorn.internal.objects.NativeArray.forEach;

/**
 *
 * @author mehmetali
 */
public class ScoreTable implements Initializable {

    @FXML ChoiceBox choiceboxSingers = new ChoiceBox();
    @FXML TableView<ScoreTableAbst> tableviewScoreTable = new TableView<>();
    @FXML Button buttonCancel = new Button();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Karaoke objMainFuncs = new Karaoke();
        ArrayList<SingerInfo> listSinger = objMainFuncs.ViewSinger(UserSession.numUserId);

        choiceboxSingers.getItems().removeAll();
        for(int i = 0; i < listSinger.size(); i++)
            choiceboxSingers.getItems().add(FXCollections.observableArrayList(listSinger.get(i).getStrUserName()));
        
        choiceboxSingers.getSelectionModel().selectedIndexProperty().addListener(
                (obs, oldV, newV) -> {
            try {
                objMainFuncs.funcListScoreTable(tableviewScoreTable, listSinger.get((int) newV).getNumID());
            } catch (SQLException ex) {
                Logger.getLogger(ScoreTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );
    }
    
    private Parent replaceSceneContent(String fxml, int numX, int numY) throws Exception {
        
        Parent page = (Parent) FXMLLoader.load(getClass().getResource(fxml));

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
    
    @FXML
    private void funcCancel() throws Exception{
        replaceSceneContent("/fxml/UserMain.fxml", 600, 471);
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
