/**
 * 
 */
package jsapi2.org.jvoicexml.jsapi2.jse.unittests.org.jvoicexml.jsapi2.jse.recognition;

import jsapi2.javax.speech.src.javax.speech.recognition.Grammar;
import jsapi2.javax.speech.src.javax.speech.recognition.GrammarManager;
import jsapi2.javax.speech.src.javax.speech.recognition.Recognizer;
import jsapi2.javax.speech.src.javax.speech.recognition.Rule;
import jsapi2.javax.speech.src.javax.speech.recognition.RuleGrammar;
import jsapi2.javax.speech.src.javax.speech.recognition.RuleToken;

import junit.framework.TestCase;

import jsapi2.org.jvoicexml.jsapi2.jse.unittests.org.jvoicexml.jsapi2.jse.test.recognition.DummyRecognizer;

/**
 * Test cases for the {@link GrammarManager}.
 * @author Dirk Schnelle-Walka
 *
 */
public class BaseGrammarManagerTest extends TestCase {
    /** The related recognizer. */
    private Recognizer recognizer;

    /** The object to test. */
    private GrammarManager manager;

    /**
     * {@inheritDoc}
     */
    protected void setUp() throws Exception {
        super.setUp();
        recognizer = new DummyRecognizer();
        manager = recognizer.getGrammarManager();
    }

    /**
     * Test method for {@link org.jvoicexml.jsapi2.jse.recognition.BaseGrammarManager#createRuleGrammar(java.lang.String, java.lang.String)}.
     * @exception Exception test failed
     */
    public void testCreateRuleGrammarStringString() throws Exception {
        final String name = "test";
        final RuleGrammar grammar =
            manager.createRuleGrammar(name, name);
        final RuleToken token = new RuleToken("hello world");
        final Rule rule = new Rule("test", token, Rule.PUBLIC);
        grammar.addRule(rule);
        recognizer.processGrammars();
        System.out.println(grammar);
        final Grammar retrievedGrammar = manager.getGrammar(name);
        assertNotNull(retrievedGrammar);
        assertEquals(grammar.toString(), retrievedGrammar.toString());
        
    }

}
