package jsapi.edu.cmu.sphinx.jsapi;

import jsapi2.javax.speech.src.javax.speech.recognition.Grammar;

import jsapi.com.sun.speech.engine.recognition.BaseResult;

import edu.cmu.sphinx.result.Result;

/**
 * JSAPI compliant recognition result.
 *
 * @author Dirk Schnelle-Walka
 * @version $Revision: 1845 $
 */
@SuppressWarnings("serial")
class Sphinx4Result
        extends BaseResult {
    /**
     * Constructs a new object.
     * @param grammar The current grammar.
     * @param result The result, returned by the sohinx4 recognizer.
     */
    public Sphinx4Result(final Grammar grammar,
                         final Result result) {
        super(grammar, result.getBestFinalResultNoFiller());
    }
}
