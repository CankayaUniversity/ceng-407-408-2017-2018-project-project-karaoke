/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import java.util.Date;
import java.sql.*;

/**
 *
 * @author mehmetali
 */
public class ScoreTableAbst {
    private String strSongName;
    private float floatScore;
    private String dateScore;
    ScoreTableAbst(){
        strSongName = "";
        floatScore = 0;
    }
    ScoreTableAbst(final String strSongName_, final float floatScore_, final String dateScore_){
        strSongName = strSongName_;
        floatScore = floatScore_;
        dateScore =  dateScore_.toString();
    }
    public String getStrSongName(){ return strSongName; }
    public void setStrSongName(final String strSongName_){ strSongName = strSongName_; }
    public float getFloatScore(){ return floatScore; }
    public void setFloatScore(final float floatScore_){ floatScore = floatScore_; }
    public String getDateScore(){ return dateScore; }
    public void setDateScore(final String dateScore_){ dateScore = dateScore_; }
}
