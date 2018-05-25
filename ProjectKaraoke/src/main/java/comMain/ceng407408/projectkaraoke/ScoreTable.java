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
import comMain.ceng407408.projectkaraoke.UserInfo;
import java.util.ArrayList;
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
    @FXML TableView tableviewScoreTable = new TableView();
    @FXML Button buttonCancel = new Button();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Karaoke objMainFuncs = new Karaoke();
        //if(user.type == type.family)
        ArrayList<UserInfo> listSinger = objMainFuncs.ViewSinger(UserSession.numUserId);
        //else
        //coreF
        choiceboxSingers.getItems().removeAll();
        for(int i = 0; i < listSinger.size(); i++)
            choiceboxSingers.getItems().add(FXCollections.observableArrayList(listSinger.get(i).funcGetUserName()));
    }
    
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
    private void funcCancel() throws Exception{
        replaceSceneContent("/fxml/UserMain.fxml");
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
