package jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2;

import java.io.InputStream;
import java.io.OutputStream;

import jsapi2.javax.speech.src.javax.speech.AudioException;
import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.AudioFormat;
import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.BaseAudioManager;

public class DummyAudioManager extends BaseAudioManager {

    public AudioFormat getAudioFormat() {
        return new AudioFormat("ulaw", 8000.0f, 16, 1, 16, 8000, false);
    }

    public InputStream getInputStream() {
        // TODO Auto-generated method stub
        return null;
    }

    public OutputStream getOutputStream() {
        // TODO Auto-generated method stub
        return null;
    }

    protected void handleAudioStart() throws AudioException {
        // TODO Auto-generated method stub

    }

    protected void handleAudioStop() throws AudioException {
        // TODO Auto-generated method stub

    }

    public void setMediaLocator(String locator, InputStream stream)
            throws AudioException, IllegalStateException,
            IllegalArgumentException, SecurityException {
        // TODO Auto-generated method stub

    }

    public void setMediaLocator(String locator, OutputStream stream)
            throws AudioException, IllegalStateException,
            IllegalArgumentException, SecurityException {
        // TODO Auto-generated method stub

    }

}
