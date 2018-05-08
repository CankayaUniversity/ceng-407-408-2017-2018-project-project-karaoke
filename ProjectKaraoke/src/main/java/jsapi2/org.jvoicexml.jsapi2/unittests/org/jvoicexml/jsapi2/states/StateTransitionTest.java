package jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.states;

import jsapi2.javax.speech.src.javax.speech.Engine;

import jsapi2.org.jvoicexml.jsapi2.src.org.jvoicexml.jsapi2.synthesis.BaseSynthesizer;
import jsapi2.org.jvoicexml.jsapi2.unittests.org.jvoicexml.jsapi2.test.synthesis.DummySynthesizer;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StateTransitionTest extends TestCase {

    private BaseSynthesizer synthesizer;

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testStateTransitions() throws Exception {
        synthesizer = new DummySynthesizer();
        
        /**
         * As per JSAPI2 a Synthesizer starts in the RESUMED state.
         */

        System.out.println(synthesizer.stateToString(synthesizer.getEngineState()));
        Assert.assertTrue((synthesizer.getEngineState() & Engine.RESUMED) != 0);
        
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
