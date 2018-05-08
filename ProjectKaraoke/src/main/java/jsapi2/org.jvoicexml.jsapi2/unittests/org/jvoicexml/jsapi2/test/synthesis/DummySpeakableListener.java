/**
 * 
 */
package jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.test.synthesis;

import jsapi2.javax.speech.src.javax.speech.synthesis.SpeakableEvent;
import jsapi2.javax.speech.src.javax.speech.synthesis.SpeakableListener;

/**
 * @author DS01191
 *
 */
public class DummySpeakableListener implements SpeakableListener {

    /**
     * {@inheritDoc}
     */
    public void speakableUpdate(SpeakableEvent e) {
        System.out.println(e);
    }

}
