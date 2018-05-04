package Recognizetranscriber;
import JavaRecordSound.JavaSoundRecorder;
import testevaluation.TestEvaluation;
import edu.cmu.sphinx.frontend.util.AudioFileDataSource;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
//import java.text.DecimalFormat;

import javax.sound.sampled.*;
import java.io.*;
import java.text.DecimalFormat;


/** A simple example that shows how to transcribe a continuous audio file that has multiple utterances in it. */
public class Transcriber {


    public double funcRecognize(String[] args) throws IOException, UnsupportedAudioFileException, InterruptedException {
        URL audioURL;
        double dobScore = 0;
        JavaSoundRecorder soundRecord = new JavaSoundRecorder();
        TestEvaluation evaluationResult =  new TestEvaluation();
        
        long RecordTime = soundRecord.GetrecordTime();
        soundRecord.startCapture();
        Thread.sleep(RecordTime + 10);
        
        if (args.length > 0) 
            audioURL = new File(args[0]).toURI().toURL();
         else 
            audioURL = Transcriber.class.getResource("RecordAudio.wav");
        

        URL configURL = Transcriber.class.getResource("config.xml");

        ConfigurationManager cm = new ConfigurationManager(configURL);
        Recognizer recognizer = (Recognizer) cm.lookup("recognizer");

        /* allocate the resource necessary for the recognizer */
        recognizer.allocate();

        // configure the audio input for the recognizer
        AudioFileDataSource dataSource = (AudioFileDataSource) cm.lookup("audioFileDataSource");
        dataSource.setAudioFile(audioURL, null);

        // Loop until last utterance in the audio file has been decoded, in which case the recognizer will return null.
        Result result;
        while ((result = recognizer.recognize())!= null) {
                String resultText = result.getBestResultNoFiller();
                System.out.println(resultText);
                DecimalFormat scoreFormat = new DecimalFormat("#00.00");
                dobScore = evaluationResult.funcResult(resultText, "one zero zero zero one one oh two one oh zero one three zero three");
                //one zero zero zero one one oh two one oh zero one three zero three
                if(dobScore == -1)
                    System.out.print("Speech text/word overrated!\n");
                else if(dobScore == -2)
                    System.out.printf("Original text/word overrated!\n");
                else System.out.println("Overall score: " + scoreFormat.format(dobScore));//strSpeech, strOriginal*/
        }
        return dobScore;
    }
}
