/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;
import EvaluationScore.ScoreAbst;
import RecognizeSpeech.Transcriber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import comMain.ceng407408.projectkaraoke.Karaoke;
import comMain.ceng407408.projectkaraoke.SongProperties;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author mehmetali
 */
public class FamilyUser implements Initializable {
    @FXML private ListView listViewSong = new ListView();
    @FXML private Button buttonLogout = new Button();
    @FXML private Button buttonScoreTable = new Button();
    @FXML private Button buttonStart = new Button();
    private static final ObservableList songNames = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Karaoke objKaraokeFunc = new Karaoke();
        try {
            ArrayList<SongProperties> listSongs = objKaraokeFunc.funcSongList();
            for(SongProperties objSong: listSongs)
                songNames.add(objSong.funcGetSongName());
            listViewSong.setEditable(true);
            listViewSong.setItems(songNames);
        } catch (SQLException ex) {
            Logger.getLogger(FamilyUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void funcKarokeStart() throws IOException, UnsupportedAudioFileException, InterruptedException, SQLException{
        Transcriber speechFunc = new Transcriber();
        Karaoke objKaraokeFunc = new Karaoke();
        ScoreAbst overallScore = speechFunc.funcRecognize(" ");
        Thread.sleep(30000);
        switch(overallScore.getProcessCode()){
            case 0:
                objKaraokeFunc.funcAddScore(0, 0, (float)overallScore.getScore(), 0);
                break;
            case -1:
                System.out.println("Words>OriginalWords");
                objKaraokeFunc.funcAddScore(0, 0, 0, 0);
                break;
            case -2:
                objKaraokeFunc.funcAddScore(0, 0, (float)overallScore.getScore(), 0);
                break;
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
