/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import RecognizeSpeech.Transcriber;

/**
 *
 * @author mehmetali
 */
public class GameKaraoke implements Initializable {
    @FXML Label labelLyrics = new Label();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
    private static void main(String[] args){
        launch(args);
    }
    
}
