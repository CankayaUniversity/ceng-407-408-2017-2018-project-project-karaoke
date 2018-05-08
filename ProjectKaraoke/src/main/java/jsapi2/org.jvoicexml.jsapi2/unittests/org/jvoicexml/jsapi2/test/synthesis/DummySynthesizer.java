package jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.test.synthesis;
import jsapi2.javax.speech.src.javax.speech.AudioException;
import jsapi2.javax.speech.src.javax.speech.AudioManager;
import jsapi2.javax.speech.src.javax.speech.EngineException;
import jsapi2.javax.speech.src.javax.speech.EngineStateException;
import jsapi2.javax.speech.src.javax.speech.SpeechEventExecutor;
import jsapi2.javax.speech.src.javax.speech.VocabularyManager;
import jsapi2.javax.speech.src.javax.speech.synthesis.Speakable;

import jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.DummyAudioManager;
import jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.DummySpeechEventExecutor;
import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.EnginePropertyChangeRequestListener;
import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.synthesis.BaseSynthesizer;

/**
 * 
 */

/**
 * @author Dirk Schnelle-Walka
 *
 */
public class DummySynthesizer extends BaseSynthesizer {

    protected Speakable getSpeakable(String text) {
        // TODO Auto-generated method stub
        return null;
    }

    protected void handleAllocate() throws EngineStateException,
            EngineException, AudioException, SecurityException {
        // TODO Auto-generated method stub
        
    }

    protected boolean handleCancel() {
        // TODO Auto-generated method stub
        return false;
    }

    protected boolean handleCancel(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    protected boolean handleCancelAll() {
        // TODO Auto-generated method stub
        return false;
    }

    protected void handleDeallocate() {
        // TODO Auto-generated method stub
    }

    protected void handlePause() {
        // TODO Auto-generated method stub
    }

    protected boolean handleResume() {
        // TODO Auto-generated method stub
        return false;
    }

    protected void handleSpeak(int id, String item) {
        // TODO Auto-generated method stub
        
    }

    protected void handleSpeak(int id, Speakable item) {
        // TODO Auto-generated method stub
        
    }

    protected AudioManager createAudioManager() {
        return new DummyAudioManager();
    }

    protected SpeechEventExecutor createSpeechEventExecutor() {
        return new DummySpeechEventExecutor();
    }

    protected VocabularyManager createVocabularyManager() {
        // TODO Auto-generated method stub
        return null;
    }

    protected EnginePropertyChangeRequestListener getChangeRequestListener() {
        // TODO Auto-generated method stub
        return null;
    }
}
