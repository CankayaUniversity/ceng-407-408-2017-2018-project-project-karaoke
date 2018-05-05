/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluationScore;

/**
 *
 * @author mehmetali
 */
public class ScoreAbst {
    // # of matched words 
    private final int numNumMatchWord;
    // total score
    private final double dobScore;
    // final status code
        // 0  -> # of Original and Recognized words are equal
        // -1 -> # of Recognized words are more than Original one
            //EXIT(FAIL)
        // -2 -> # of REcognized words are less than Original one
            // User missed some words!
    private final int numProcessCode;
    
    public ScoreAbst(){
        numNumMatchWord = 0;
        dobScore = 0;
        numProcessCode = 0;
    }
    
    public ScoreAbst(final int _numNumMatchWord, final double _dobScore, final int _numProcessCode) {
        numNumMatchWord = _numNumMatchWord;
        dobScore = _dobScore;
        numProcessCode = _numProcessCode;
    }
    
    public double getScore(){ return dobScore; }
    public int getMatchWord(){ return numNumMatchWord; }
    public int getProcessCode(){ return numProcessCode; }
}
