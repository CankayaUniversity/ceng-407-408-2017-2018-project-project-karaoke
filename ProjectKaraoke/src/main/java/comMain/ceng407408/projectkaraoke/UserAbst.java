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
public class UserAbst {

    private String strName;
    private String strSurname;
    private float floatAverage;

    UserAbst() {
        strName = strSurname = "";
        floatAverage = 0;
    }

    UserAbst(final String strName_, final String strSurname_, final float floatAverage_) {
        this.strName = strName_;
        this.strSurname = strSurname_;
        this.floatAverage = floatAverage_;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName_) {
        strName = strName_;
    }

    public String getStrSurname() {
        return strSurname;
    }

    public void setStrSurname(String strSurname_) {
        strSurname = strSurname_;
    }

    public float getFloatAverage() {
        return floatAverage;
    }

    public void setFloatAverage(float floatAverage_) {
        floatAverage = floatAverage_;
    }

}
