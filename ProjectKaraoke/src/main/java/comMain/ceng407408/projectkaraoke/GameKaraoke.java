/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import EvaluationScore.ScoreAbst;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import RecognizeSpeech.Transcriber;
import UserStatic.KaraokeCache;
import UserStatic.UserSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author mehmetali
 */
public class GameKaraoke implements Initializable {

    @FXML
    Label labelLyrics = new Label();
    @FXML
    Label labelSingerName = new Label();
    @FXML
    Label labelSongName = new Label();
    @FXML
    Button buttonStart = new Button();
    private final Karaoke objMainFunc = new Karaoke();

    @FXML
    private void funcStartKaraoke() throws SQLException, IOException, UnsupportedAudioFileException, InterruptedException {
        try {
            Alert alert = null;
            DecimalFormat decformScoreFormat = new DecimalFormat("###.##");
            String strLyric = objMainFunc.funcGetLyric(KaraokeCache.numSongID);
            long longRecordTime = objMainFunc.funcGetTime(KaraokeCache.numSongID);
            Transcriber speechFunc = new Transcriber();
            ScoreAbst overallScore = speechFunc.funcRecognize(" ", longRecordTime);
            Thread.sleep(longRecordTime);
            switch (overallScore.getProcessCode()) {
                case 0:
                    objMainFunc.funcAddScore(UserSession.numUserId, KaraokeCache.numSingerID, (float) overallScore.getScore(), KaraokeCache.numSongID);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Congratulations!");
                    alert.setContentText("Your score: " + decformScoreFormat.format(overallScore.getScore()));
                    break;
                case -1:
                    objMainFunc.funcAddScore(UserSession.numUserId, KaraokeCache.numSingerID, 0, KaraokeCache.numSongID);
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Thats bad!");
                    alert.setContentText("You said more then original lyrics!");
                    break;
                case -2:
                    objMainFunc.funcAddScore(UserSession.numUserId, KaraokeCache.numSingerID, (float) overallScore.getScore(), KaraokeCache.numSongID);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Congratulations!");
                    alert.setContentText("Your score: " + decformScoreFormat.format(overallScore.getScore()) + "\n You missed some words!");
                    break;                    
            }                       
            alert.showAndWait();
        } catch (SQLException exExc) {

        }
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

    private static void main(String[] args) {
        launch(args);
    }

}
