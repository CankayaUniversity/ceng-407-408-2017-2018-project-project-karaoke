/**
 * 
 */
package jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.synthesis;

import jsapi2.javax.speech.src.javax.speech.AudioSegment;
import jsapi2.javax.speech.src.javax.speech.synthesis.SpeakableListener;
import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.synthesis.BaseSynthesizer;
import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.synthesis.QueueItem;
import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.synthesis.QueueManager;

import junit.framework.Assert;
import junit.framework.TestCase;

import jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.test.synthesis.DummySpeakableListener;
import jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.test.synthesis.DummySynthesizer;

/**
 * Test cases for {@link QueueManager}.
 * @author Dirk Schnelle-Walka
 *
 */
public final class QueueManagerTest extends TestCase {
    /** Synthesizer. */
    private BaseSynthesizer synthesizer;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        synthesizer = new DummySynthesizer();
    }

    /**
     * Test method for {@link org.jvoicexml.jsapi2.jse.synthesis.QueueManager#appendItem(javax.speech.synthesis.Speakable, javax.speech.synthesis.SpeakableListener)}.
     * @exception Exception
     *            test failed.
     */
    public void testAppendItemSpeakableSpeakableListener() throws Exception {
        QueueManager manager = synthesizer.getQueueManager();
        AudioSegment segment = new AudioSegment("http://nowhere", "test");
        SpeakableListener listener = new DummySpeakableListener();
        manager.appendItem(segment, listener);
        QueueItem item = manager.getQueueItem();
        Assert.assertNotNull(item);
        Assert.assertEquals(segment, item.getAudioSegment());
        Assert.assertEquals(listener, item.getListener());
        Thread.sleep(10000);
    }

}
