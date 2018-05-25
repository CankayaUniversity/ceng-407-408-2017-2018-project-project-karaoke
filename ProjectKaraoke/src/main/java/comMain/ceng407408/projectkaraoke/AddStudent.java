/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;
import UserStatic.UserSession;
import static comMain.ceng407408.projectkaraoke.MainApp.stage;
import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
/**
 *
 * @author mehmetali
 */
public class AddStudent implements Initializable {
    
    @FXML TextField textfieldSurname = new TextField();
    @FXML TextField textfieldName = new TextField();
    @FXML Label labelError = new Label();
    private Karaoke objMainFunc = new Karaoke();
    
    @FXML
    private void funcAddStudent(){
        labelError.setVisible(true);
        if(!textfieldName.getText().isEmpty() && !textfieldSurname.getText().isEmpty()){
            objMainFunc.funcAddSinger(textfieldName.getText(), textfieldSurname.getText(), UserSession.numUserId);
            labelError.setText("Successfully added!");
        }
        else labelError.setText("Could not added to the database!");
    }
    
    @FXML
    private void funcCancel() throws Exception{
        replaceSceneContent("/fxml/UserMain.fxml");
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
    private static void main(String[] args){
        launch(args);
    }
}
