/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecordSound;

/**
 *
 * @author MehmetAliBekereci
 */
import javax.sound.sampled.*;
import java.io.*;

/**
 * Recording sound and saving as a wav file
 */
public class JavaSoundRecorder {

    public JavaSoundRecorder() throws LineUnavailableException {
        RECORD_TIME = 10000;
        wavFile = new File("/Users/sevtap/Downloads/Project2/srcbeta/sphinx4-1.0beta6/src/edu/cmu/sphinx/demo/transcriber/RecordAudio.wav");
        fileType = AudioFileFormat.Type.WAVE;
        AudioFormat format = getAudioFormat();
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

        // checks if system supports the data line
        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Line not supported");
            System.exit(0);
        }
        line = (TargetDataLine) AudioSystem.getLine(info);
        line.open(format);
    }
    // record duration, in milliseconds
    static long RECORD_TIME = 10000;	// 10 seconds
    // path of the wav file
    File wavFile = new File("/Users/sevtap/Downloads/Project2/srcbeta/sphinx4-1.0beta6/src/edu/cmu/sphinx/demo/transcriber/RecordAudio.wav");

    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

    // the line from which audio data is captured
    TargetDataLine line;

    /**
     * Defines an audio format
     */
    static AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        return format;
    }

    public long GetrecordTime() {
        return RECORD_TIME;
    }

    public void SetrecordTime(final long RCORD_TIME) {
        RECORD_TIME = RCORD_TIME;
    }

    /**
     * Captures the sound and record into a WAV file
     */
    void start() {
        try {
            /*AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);*/
            line.start();	// start capturing

            System.out.println("Start capturing...");

            AudioInputStream ais = new AudioInputStream(line);

            System.out.println("Start recording...");

            // start recording
            AudioSystem.write(ais, fileType, wavFile);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Closes the target data line to finish capturing and recording
     */
    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }

    public void startCapture() throws LineUnavailableException {
        Recording();
    }

    /**
     * Entry to run the program
     */
    private static void Recording() throws LineUnavailableException {
        final JavaSoundRecorder recorder = new JavaSoundRecorder();

        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });

        stopper.start();

        // start recording
        recorder.start();
    }
}
