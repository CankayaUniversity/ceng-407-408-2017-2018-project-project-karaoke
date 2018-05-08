/**
 *
 */
package jsapi2.org.jvoicexml.jsapi2.jse.unittests.org.jvoicexml.jsapi2.jse.recognition;

import jsapi2.javax.speech.src.javax.speech.recognition.GrammarManager;
import jsapi2.javax.speech.src.javax.speech.recognition.Rule;
import jsapi2.javax.speech.src.javax.speech.recognition.RuleComponent;
import jsapi2.javax.speech.src.javax.speech.recognition.RuleGrammar;
import jsapi2.javax.speech.src.javax.speech.recognition.RuleSequence;
import jsapi2.javax.speech.src.javax.speech.recognition.RuleTag;
import jsapi2.javax.speech.src.javax.speech.recognition.RuleToken;
import jsapi2.org.jvoicexml.jsapi2.jse.src.org.jvoicexml.jsapi2.jse.recognition.BaseResult;
import jsapi2.org.jvoicexml.jsapi2.jse.src.org.jvoicexml.jsapi2.jse.recognition.JseBaseRecognizer;

import org.junit.Test;
import jsapi2.org.jvoicexml.jsapi2.jse.unittests.org.jvoicexml.jsapi2.jse.test.recognition.DummyRecognizer;

/**
 * Test cases for {@link BaseResult}.
 *
 * @author Dirk Schnelle-Walka
 *
 */
public class BaseResultTest {

    /**
     * Test method for
     * {@link org.jvoicexml.jsapi2.jse.recognition.BaseResult#getTags(int)}.
     *
     * @exception Exception test failed
     */
    @Test
    public void testGetTags() throws Exception {
        final JseBaseRecognizer recognizer = new DummyRecognizer();
        final GrammarManager manager = recognizer.getGrammarManager();
        final RuleGrammar grammar
                = manager.createRuleGrammar("grammar:test", "test");
        final RuleComponent[] components = new RuleComponent[]{
            new RuleToken("test"),
            new RuleTag("T")
        };
        final RuleSequence sequence = new RuleSequence(components);
        final Rule root = new Rule("test", sequence, Rule.PUBLIC);
        grammar.addRule(root);
        recognizer.processGrammars();
        System.out.println(grammar);
        final BaseResult result = new BaseResult(grammar, "test");
        final Object[] tags = result.getTags(1);
        System.out.println(tags[0]);
    }

}
