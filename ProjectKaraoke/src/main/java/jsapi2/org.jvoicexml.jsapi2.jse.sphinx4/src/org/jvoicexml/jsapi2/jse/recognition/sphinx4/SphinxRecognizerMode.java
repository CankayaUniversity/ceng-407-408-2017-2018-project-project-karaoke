package jsapi2.org.jvoicexml.jsapi2.jse.sphinx4.src.org.jvoicexml.jsapi2.jse.recognition.sphinx4;

import jsapi2.javax.speech.src.javax.speech.Engine;
import jsapi2.javax.speech.src.javax.speech.EngineException;
import jsapi2.javax.speech.src.javax.speech.SpeechLocale;
import jsapi2.javax.speech.src.javax.speech.recognition.RecognizerMode;
import jsapi2.javax.speech.src.javax.speech.spi.EngineFactory;

/**
 * <p>Title: JSAPI 2.0</p>
 *
 * <p>Description: An independent reference implementation of JSR 113</p>
 *
 * <p>Copyright: Copyright (c) 2007-2008</p>
 *
 * <p>Company: JVoiceXML group - http://jvoicexml.sourceforge.net</p>
 *
 * @author Renato Cassaca
 * @version 1.0
 */
public class SphinxRecognizerMode extends RecognizerMode implements EngineFactory {
    public SphinxRecognizerMode() {
        super("sphinx4", null, true, false, true, 10000,
                new SpeechLocale[] {new SpeechLocale("en_US")}, null);
    }

    /**
     * @todo Search for all voices in classpath
     *
     * @return Engine
     * @throws EngineException
     */
    public Engine createEngine() throws EngineException {
        return new Sphinx4Recognizer(this);
    }
}
