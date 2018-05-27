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
import static comMain.ceng407408.projectkaraoke.MainApp.stage;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBuilder;
import javafx.util.Duration;
import javax.sound.sampled.UnsupportedAudioFileException;
import javafx.scene.paint.Color;

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

    private Parent replaceSceneContent(String fxml, int numX, int numY) throws Exception {
        Parent page;
        page = (Parent) FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, numX, numY);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }

        //stage.getScene().setRoot(page);
        //stage.setScene(page.getScene());
        stage.setMinHeight(numY);
        stage.setMinWidth(numX);
        stage.setMaxHeight(numY);
        stage.setMaxWidth(numX);
        stage.setResizable(false);
        stage.setTitle("");
        stage.show();
        return page;
    }

    private void funcAnimateLyric(final String strLyric, final long longDurationTime) {
        labelLyrics.setText(TextBuilder.create()
                .text(strLyric)
                .layoutX(50)
                .textOrigin(VPos.CENTER)
                .textAlignment(TextAlignment.CENTER)
                .fill(Color.RED)
                .font(Font.font("SansSerif", FontPosture.ITALIC, 18))
                .build().toString());

        TranslateTransition translateTransition = TranslateTransitionBuilder.create()
                .node(labelLyrics)
                .fromY(500)
                .toY(-500)
                .duration(new Duration(longDurationTime))
                .interpolator(Interpolator.LINEAR)
                .cycleCount(Timeline.INDEFINITE)
                .build();
        translateTransition.play();
    }

    @FXML
    private void funcStartKaraoke() throws SQLException, IOException, UnsupportedAudioFileException, InterruptedException, Exception {
        try {
            Alert alert = null;
            DecimalFormat decformScoreFormat = new DecimalFormat("###.##");
            String strLyric = objMainFunc.funcGetLyric(KaraokeCache.numSongID);
            long longRecordTime = objMainFunc.funcGetTime(KaraokeCache.numSongID);
            Transcriber speechFunc = new Transcriber();
            funcAnimateLyric(strLyric, longRecordTime);
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Something gone wrong!");
            alert.showAndWait();
        }
        replaceSceneContent("/fxml/UserMain.fxml", 600, 471);
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
