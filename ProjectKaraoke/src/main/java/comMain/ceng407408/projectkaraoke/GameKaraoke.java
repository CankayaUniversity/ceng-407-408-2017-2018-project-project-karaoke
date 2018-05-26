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
import UserStatic.KaraokeCache;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

/**
 *
 * @author mehmetali
 */
public class GameKaraoke implements Initializable {
    @FXML Label labelLyrics = new Label();
    @FXML Label labelSingerName = new Label();
    @FXML Label labelSongName = new Label();
    @FXML Button buttonStart = new Button();
    private final Karaoke objMainFunc = new Karaoke();
    
    @FXML
    private void funcStartKaraoke(){
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            labelSingerName.setText(objMainFunc.funcGetSingerName(KaraokeCache.numSingerID));
            labelSongName.setText(objMainFunc.funcGetSongName(KaraokeCache.numSongID));
        } catch (SQLException ex) {
            Logger.getLogger(GameKaraoke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void main(String[] args){
        launch(args);
    }
    
}
