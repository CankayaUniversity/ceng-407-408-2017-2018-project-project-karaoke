/**
 * 
 */
package jsapi2.org.jvoicexml.jsapi2.jse.unittests.org.jvoicexml.jsapi2.jse.synthesis;

import jsapi2.javax.speech.src.javax.speech.AudioException;
import jsapi2.javax.speech.src.javax.speech.Engine;
import jsapi2.javax.speech.src.javax.speech.EngineException;
import jsapi2.javax.speech.src.javax.speech.EngineStateException;
import jsapi2.javax.speech.src.javax.speech.synthesis.Synthesizer;

import junit.framework.Assert;

import org.junit.Test;
import jsapi2.org.jvoicexml.jsapi2.jse.unittests.org.jvoicexml.jsapi2.jse.test.synthesis.DummySynthesizer;

/**
 * Test cases for {@link JseBaseSynthesizer}.
 * @author Dirk Schnelle-Walka
 *
 */
public class JseBaseSynthesizerTest {

    /**
     * Test method for {@link org.jvoicexml.jsapi2.BaseEngine#allocate()}.
     * @throws Exception 
     *         test failed
     */
    @Test
    public void testAllocate() throws Exception {
        final DummySynthesizer synthesizer = new DummySynthesizer();
        final long state1 = synthesizer.getEngineState();
        Assert.assertEquals(Engine.DEALLOCATED, state1);
        synthesizer.allocate();
        synthesizer.waitEngineState(Engine.ALLOCATED);
        final long state2 = synthesizer.getEngineState();
        Assert.assertEquals(Engine.ALLOCATED | Engine.PAUSED,
                Synthesizer.QUEUE_EMPTY | Engine.DEFOCUSED, state2);
    }

}
