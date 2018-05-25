package comMain.ceng407408.projectkaraoke;

import EvaluationScore.ScoreAbst;
import RecognizeSpeech.Transcriber; 

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaMarkerEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javax.sound.sampled.UnsupportedAudioFileException;
/*import org.fredy.jsrt.api.SRT;
import org.fredy.jsrt.api.SRTInfo;
import org.fredy.jsrt.api.SRTReader;
import org.fredy.jsrt.api.SRTTimeFormat;*/

public class FXMLController implements Initializable {
  
    
    @FXML
    public ImageView imageAnimation;
    @FXML
    public VBox closedCaption;
    @FXML
    public Label labelVbox;
    @FXML
    public MediaView mediaT;
    MediaPlayer player;
    Media pick;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

    }
    private  void print() {
        
    }
    public void AnimateText(final Label lbl, String descImp) {
        final String content = descImp;
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
            }

            protected void interpolate(double frac) {
                final int length = content.length();
                final int n = Math.round(length * (float) frac);
                lbl.setText(content.substring(0, n));


            }
        };
        animation.play();

    }
    public void AnimateTextWithColor(final Label lbl, String descImp) {
        final String content = descImp;
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(4000));
            }

            protected void interpolate(double frac) {
                final int length = content.length();
                final int n = Math.round(length * (float) frac);
                lbl.setTextFill(Color.RED);

            }
        };
        animation.play();

    }
}
