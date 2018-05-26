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
public class SingerInfo {
    private int numUserType;
    private int numID;
    private String strUserName;
    private String strUserPassword;
    private float floatAvrScore;
    
    SingerInfo(){
        numUserType = numID = 0;
        floatAvrScore = 0;
        strUserName = strUserPassword = "";
    }
    
    SingerInfo(final int numID_, final int numUserType_, final String strUserName_, final String strUserPassword_, final float floatAvrScore_){
        numID = numID_;
        numUserType = numUserType_;
        strUserName = strUserName_;
        floatAvrScore = floatAvrScore_;
        strUserPassword = strUserPassword_;
    }
    
    public int getNumID(){ return numID; }
    public int getNumUserType(){ return numUserType; }
    public String getStrUserName() { return strUserName; }
    public float getFloatAvrScore() { return floatAvrScore; }
}
