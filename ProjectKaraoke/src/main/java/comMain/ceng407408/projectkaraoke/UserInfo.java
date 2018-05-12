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
public class UserInfo {
    private int numUserType;
    private String strUserName;
    private String strUserPassword;
    private float floatAvrScore;
    
    UserInfo(){
        numUserType = 0;
        floatAvrScore = 0;
        strUserName = strUserPassword = "";
    }
    
    UserInfo(final int numUserType_, final String strUserName_, final String strUserPassword_, final float floatAvrScore_){
        numUserType = numUserType_;
        strUserName = strUserName_;
        floatAvrScore = floatAvrScore_;
        strUserPassword = strUserPassword_;
    }
    
    public int funcGetUserType(){ return numUserType; }
    public String funcGetUserName() { return strUserName; }
    public float funcGetAvrScore() { return floatAvrScore; }
}
