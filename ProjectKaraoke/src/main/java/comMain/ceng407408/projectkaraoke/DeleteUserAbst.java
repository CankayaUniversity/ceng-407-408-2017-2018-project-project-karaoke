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
public class DeleteUserAbst {

    private String numID;
    private String strMail;
    private String strName;

    DeleteUserAbst() {
        numID = "";
        strMail = strName = "";
    }

    DeleteUserAbst(final int numID_, final String strMail_, final String strName_) {
        numID = String.valueOf(numID_);
        strMail = strMail_;
        strName = strName_;
    }

    public String getNumID() {
        return numID;
    }

    public String getStrMail() {
        return strMail;
    }

    public String getStrName() {
        return strName;
    }
}
