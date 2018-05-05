package RecognizeSpeech;
import EvaluationScore.ScoreAbst;
import RecordSound.JavaSoundRecorder;
import EvaluationScore.TestEvaluation;
import edu.cmu.sphinx.frontend.util.AudioFileDataSource;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
//import java.text.DecimalFormat;

import java.text.DecimalFormat;


/** A simple example that shows how to transcribe a continuous audio file that has multiple utterances in it. */
public class Transcriber {


    public ScoreAbst funcRecognize(String strOriginalLyric) throws IOException, UnsupportedAudioFileException, InterruptedException {
        URL audioURL;
        ScoreAbst finalScore = new ScoreAbst();
        JavaSoundRecorder soundRecord = new JavaSoundRecorder();
        TestEvaluation evaluationResult =  new TestEvaluation();
        
        long RecordTime = soundRecord.GetrecordTime();
        soundRecord.startCapture();
        Thread.sleep(RecordTime + 10);
        
        //Way of getting resource may change
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
                finalScore = evaluationResult.funcResult(resultText, strOriginalLyric);
                //one zero zero zero one one oh two one oh zero one three zero three
                /*if(dobScore == -1)
                    System.out.print("Speech text/word overrated!\n");
                else if(dobScore == -2)
                    System.out.printf("Original text/word overrated!\n");
                else System.out.println("Overall score: " + scoreFormat.format(dobScore));//strSpeech, strOriginal*/
                switch(finalScore.getProcessCode()){
                    case 0:
                        System.out.println("Overall score: " + scoreFormat.format(finalScore.getScore()));
                        break;
                    case -1:
                        System.err.println("Number of recognized words are more than original one!");
                        break;
                    case -2:
                        System.out.println("Number of macthed words are lower than the original one!");
                        System.out.println("Overall score: " + scoreFormat.format(finalScore.getScore()));
                        break;
                }
        }
        return finalScore;
    }
}
