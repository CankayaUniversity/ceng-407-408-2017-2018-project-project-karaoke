/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluationScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestEvaluation {

    public double funcResult(String strSpeechToText, String strOriginal) {
        return funcEvaluate(strSpeechToText, strOriginal);
    }
    private static double funcEvaluate(String strSpeechToText, String strOriginal){
        double dobScore = 0;
        int numFrequency = 0;
        strSpeechToText = strSpeechToText.replace('\n', '-');
        strSpeechToText = strSpeechToText.replace(' ', '-');
        
        strOriginal = strOriginal.replace('\n', '-');
        strOriginal = strOriginal.replace(' ', '-');
        ArrayList<String> listSpeech = new ArrayList<>(Arrays.asList(strSpeechToText.split("-")));
        ArrayList<String> listOriginal = new ArrayList<>(Arrays.asList(strOriginal.split("-")));

        Map<String, Integer> mapFrequency = new HashMap<>();
        
        for (String listSpeech1 : listSpeech) 
            System.out.printf("Speech: " + listSpeech1 + '\n');
        for (String listOriginal1 : listOriginal) 
            System.out.printf("Original: " + listOriginal1 + '\n');
        
        dobScore = listSpeech.size();
        if(listSpeech.size() > listOriginal.size())
            return -1;
        if(listSpeech.size() < listOriginal.size()){
            for(String strWord : listOriginal){
                numFrequency = (Collections.frequency(listSpeech, strWord));
                if(!mapFrequency.containsKey(strWord))
                    mapFrequency.put(strWord, numFrequency);
                else mapFrequency.replace(strWord, numFrequency++);                
            }
            for(String strWord : mapFrequency.keySet()){
                numFrequency = mapFrequency.get(strWord).intValue();
                if(numFrequency == 0)
                    dobScore = dobScore - Collections.frequency(listOriginal, strWord);
                else{
                    int numOrgFreq = Collections.frequency(listOriginal, strWord);
                    if(numOrgFreq > numFrequency)
                        dobScore = dobScore - (numOrgFreq - numFrequency);
                }
            }
            //return -2;
             return ((dobScore * 100) / listOriginal.size());
        }
        
        for(int i = 0 ; i < listSpeech.size() ; i++)
            if(listSpeech.get(i).compareTo(listOriginal.get(i)) != 0)
                dobScore--;
        return ((dobScore * 100) / listOriginal.size());
    }    
}
