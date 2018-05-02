package sample;

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
import org.fredy.jsrt.api.SRT;
import org.fredy.jsrt.api.SRTInfo;
import org.fredy.jsrt.api.SRTReader;
import org.fredy.jsrt.api.SRTTimeFormat;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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
        pick = new Media(Paths.get("zxczxc.mp3").toUri().toString());
        File file = new File("tenor.gif");
        Image image = new Image(file.toURI().toString());
        SRTInfo info = SRTReader.read(new File("test.srt"));
        print(info);

        player = new MediaPlayer(pick);
        player.setAutoPlay(true);
         player.setOnMarker(new EventHandler<MediaMarkerEvent>() {
            @Override
            public void handle(MediaMarkerEvent event) {

                AnimateText(labelVbox,event.getMarker().getKey());
                AnimateTextWithColor(labelVbox,event.getMarker().getKey());

            }

        });

        mediaT.setMediaPlayer(player);
        mediaT.getMediaPlayer().play();

        imageAnimation.setImage(image);


    }
    private  void print(SRTInfo info) {
        long milliseconds;
        long endmilliseconds;
        long minMil = 0;
        for (SRT s : info) {


            String test = "";
            System.out.println("Number: " + s.number);
            System.out.println("Start time: " + SRTTimeFormat.format(s.startTime));
           System.out.println("End time: " + SRTTimeFormat.format(s.endTime));
           // System.out.println("Texts:");
            for (String line : s.text) {
                System.out.println("    " + line);
                test += s.text + "\n" ;
            }
             milliseconds = s.startTime.getTime();
             endmilliseconds = s.endTime.getTime();
            minMil += endmilliseconds - milliseconds;
            System.out.println(Duration.millis(endmilliseconds - milliseconds));
            pick.getMarkers().put(test, Duration.millis((minMil)));


            System.out.println();
        }
    }

    public void AnimateText(Label lbl, String descImp) {
        String content = descImp;
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
    public void AnimateTextWithColor(Label lbl, String descImp) {
        String content = descImp;
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
