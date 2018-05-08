/**
 * 
 */
package jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2;

import jsapi2.javax.speech.src.javax.speech.SpeechEventExecutor;

/**
 * A speech event executor that can be terminated.
 * @author Dirk Schnelle-Walka
 *
 */
public interface TerminatableSpeechEventExecutor extends SpeechEventExecutor {
    /**
     * Terminate this speech event executor.
     */
    void terminate();
}
