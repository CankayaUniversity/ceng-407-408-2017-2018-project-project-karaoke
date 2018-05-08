/**
 * 
 */
package jsapi2.org.jvoicexml.jsapi2.jse.unittests.org.jvoicexml.jsapi2.jse.test.recognition;

import java.util.Vector;

import jsapi2.javax.speech.src.javax.speech.AudioException;
import jsapi2.javax.speech.src.javax.speech.EngineException;
import jsapi2.javax.speech.src.javax.speech.EngineStateException;
import jsapi2.javax.speech.src.javax.speech.SpeechEventExecutor;

import jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.DummySpeechEventExecutor;
import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.EnginePropertyChangeRequestListener;
import jsapi2.org.jvoicexml.jsapi2.jse.src.org.jvoicexml.jsapi2.jse.ThreadSpeechEventExecutor;
import jsapi2.org.jvoicexml.jsapi2.jse.src.org.jvoicexml.jsapi2.jse.recognition.JseBaseRecognizer;

/**
 * Dummy implementation of a recognizer for test purposes.
 * @author Dirk Schnelle-Walka
 *
 */
public class DummyRecognizer extends JseBaseRecognizer {

    /* (non-Javadoc)
     * @see org.jvoicexml.jsapi2.jse.recognition.BaseRecognizer#getBuiltInGrammars()
     */
    @Override
    public Vector getBuiltInGrammars() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.jvoicexml.jsapi2.jse.recognition.BaseRecognizer#handleAllocate()
     */
    @Override
    protected void handleAllocate() throws EngineStateException,
            EngineException, AudioException, SecurityException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.jvoicexml.jsapi2.jse.recognition.BaseRecognizer#handleDeallocate()
     */
    @Override
    protected void handleDeallocate() {
    }

    /* (non-Javadoc)
     * @see org.jvoicexml.jsapi2.jse.recognition.BaseRecognizer#handlePause()
     */
    @Override
    protected void handlePause() {
    }

    /* (non-Javadoc)
     * @see org.jvoicexml.jsapi2.jse.recognition.BaseRecognizer#handlePause(int)
     */
    @Override
    protected void handlePause(int flags) {
    }

    /* (non-Javadoc)
     * @see org.jvoicexml.jsapi2.jse.recognition.BaseRecognizer#handleResume()
     */
    @Override
    protected boolean handleResume() {
        // TODO Auto-generated method stub
        return false;
    }


    /* (non-Javadoc)
     * @see org.jvoicexml.jsapi2.BaseEngine#getChangeRequestListener()
     */
    @Override
    protected EnginePropertyChangeRequestListener getChangeRequestListener() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected boolean setGrammars(Vector grammarDefinition) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void handleRequestFocus() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void handleReleaseFocus() {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SpeechEventExecutor createSpeechEventExecutor() {
        return new ThreadSpeechEventExecutor();
    }

}
