package jsapi2.org.jvoicexml.jsapi2.jse.unittests.org.jvoicexml.jsapi2.jse.test.synthesis;
import javax.sound.sampled.AudioFormat;
import jsapi2.javax.speech.src.javax.speech.AudioException;
import jsapi2.javax.speech.src.javax.speech.EngineException;
import jsapi2.javax.speech.src.javax.speech.EngineStateException;
import jsapi2.javax.speech.src.javax.speech.synthesis.Speakable;

import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.EnginePropertyChangeRequestListener;
import jsapi2.org.jvoicexml.jsapi2.jse.src.org.jvoicexml.jsapi2.jse.synthesis.JseBaseSynthesizer;

/**
 * 
 */

/**
 * @author Dirk Schnelle-Walka
 *
 */
public class DummySynthesizer extends JseBaseSynthesizer {
    @Override
    protected void handleAllocate() throws EngineStateException,
            EngineException, AudioException, SecurityException {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected boolean handleCancel() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean handleCancel(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean handleCancelAll() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void handleDeallocate() {
    }

    @Override
    protected void handlePause() {
    }

    @Override
    protected boolean handleResume() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void handleSpeak(int id, String item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void handleSpeak(int id, Speakable item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected EnginePropertyChangeRequestListener getChangeRequestListener() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected AudioFormat getAudioFormat() {
        // TODO Auto-generated method stub
        return null;
    }
}
