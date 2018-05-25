/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;
import UserStatic.UserSession;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
/**
 *
 * @author mehmetali
 */
public class AddStudent {
    
    @FXML TextField textfieldSurname = new TextField();
    @FXML TextField textfieldName = new TextField();
    private Karaoke objMainFunc = new Karaoke();
    
    @FXML
    private void funcAddStudent(){
        if(!textfieldName.getText().isEmpty() && !textfieldSurname.getText().isEmpty())
            objMainFunc.funcAddSinger(textfieldName.getText(), textfieldSurname.getText(), UserSession.numUserId);
    }
    
    private static void main(String[] args){
        launch(args);
    }
}
