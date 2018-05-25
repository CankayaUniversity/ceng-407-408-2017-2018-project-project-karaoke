/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import UserStatic.UserSession;
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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javax.swing.event.ChangeListener;
import static jdk.nashorn.internal.objects.NativeArray.forEach;

/**
 *
 * @author mehmetali
 */
public abstract class ScoreTable implements ChangeListener, Initializable {

    @FXML
    ChoiceBox choiceboxSingers = new ChoiceBox();
    @FXML
    TableView tableviewScoreTable = new TableView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Karaoke objMainFuncs = new Karaoke();
        //if(user.type == type.family)
        ArrayList<UserInfo> listSinger = objMainFuncs.ViewSinger(UserSession.numUserId);
        //else
        //coreF
    }
}
