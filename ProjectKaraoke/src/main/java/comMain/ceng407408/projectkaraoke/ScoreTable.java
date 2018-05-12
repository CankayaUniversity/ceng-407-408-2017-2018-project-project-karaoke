/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.ListView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import comMain.ceng407408.projectkaraoke.UserInfo;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javax.swing.event.ChangeListener;
import static jdk.nashorn.internal.objects.NativeArray.forEach;
/**
 *
 * @author mehmetali
 */
public class ScoreTable{
    @FXML private ChoiceBox cbListPeople =  new ChoiceBox();
    @FXML private ListView lwScoreTable =  new ListView();
    @FXML private Button butBack =  new Button();
    public void initialize(URL location, ResourceBundle resources){
        //Determine whether a user is "family" or "teacher"
        //Assuming users info stored in cache as an encapsulated form
        // which includes: 
            //UserID
            //UserType:
                //0 -> family
                //1 -> teacher
        Karaoke coreFuncs =  new Karaoke();
        //if(user.type == type.family)
        ArrayList<UserInfo> listSinger = coreFuncs.ViewSinger(0);
        //else
            //coreFuncs.ViewSinger(1);
        if(!listSinger.isEmpty()){
            //for(UserInfo objUserInfo : listSinger){
            cbListPeople.setItems(FXCollections.observableArrayList(listSinger));
            //}
            /*ChangeListener<UserInfo> changeListener = new ChangeListener<UserInfo>() {
                @Override
            public void changed(ObservableValue<? extends UserInfo> observable, //
                    UserInfo oldValue, UserInfo newValue) {
                if (newValue != null) {
                    //greetingLabel.setText(newValue.getGreeting());
                }
            }
        };*/
            //cbListPeople.getSelectionModel().selectedIndexProperty().addListener(changeListener);
        }
            
    }
    @FXML public void funcDisplayScoreT(){
        
    }
}
