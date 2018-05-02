/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testevaluation;

import java.util.*;
import java.lang.String;

public class TestEvaluation {

    public double funcResult(String strSpeechToText, String strOriginal) {
        return funcEvaluate(strSpeechToText, strOriginal);
        /*if(dobScore == -1)
            System.out.print("Speech error!");
        else if(dobScore == -2)
            System.out.printf("Original error!");
        else  System.out.println("Score : " + dobScore + "%\n");*/
    }
    private static double funcEvaluate(String strSpeechToText, String strOriginal){
        double dobScore = 0;
        strSpeechToText = strSpeechToText.replace('\n', '-');
        strSpeechToText = strSpeechToText.replace(' ', '-');
        
        strOriginal = strOriginal.replace('\n', '-');
        strOriginal = strOriginal.replace(' ', '-');
        String[] listSpeech = funcDivide(strSpeechToText);
        String[] listOriginal = funcDivide(strOriginal);
        for (String listSpeech1 : listSpeech) 
            System.out.printf("Speech: " + listSpeech1 + '\n');
        for (String listOriginal1 : listOriginal) 
            System.out.printf("Original: " + listOriginal1 + '\n');
        if(listSpeech.length > listOriginal.length)
            return -1;
        if(listSpeech.length < listOriginal.length)
            return -2;
        dobScore = listSpeech.length;
        for(int i = 0 ; i < listSpeech.length ; i++)
            if(listSpeech[i].compareTo(listOriginal[i]) != 0)
                //dobScore -= ((double)(listSpeech[i].compareTo(listOriginal[i])) / 100.);
                dobScore--;
        return ((dobScore * 100) / listSpeech.length);
    }
    
    private static String[] funcDivide(String strText)
    {
        return strText.split("-") ;
    }
    
}
