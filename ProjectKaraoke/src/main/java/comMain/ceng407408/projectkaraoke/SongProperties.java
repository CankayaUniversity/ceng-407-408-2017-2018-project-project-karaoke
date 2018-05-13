/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

/**
 *
 * @author mehmetali
 */
public class SongProperties {
    private int numSongID;
    private String strSongName;
    private String strLyric;
    
    SongProperties(){
        numSongID = 0;
        strSongName = strLyric = "";
    }
    
    SongProperties(final int numSongID_, String strSongName_, String strLyric_){
        numSongID = numSongID_;
        strSongName = strSongName_;
        strLyric = strLyric_;
    }
    
    public int funcGetSongID() { return numSongID; }
    public String funcGetSongName() { return strSongName; }
    public String funcGetLyric() { return strLyric; }
}
