/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

/**
 *
 * @author sevtap
 */
public class UserPersonalInformation {
    
    private String Name;
    private String Surname;
    private int Password;
    private String Mail;
    
    UserPersonalInformation(){
        Name = "";
        Surname = "";
        Mail ="";
        Password = 0;
    }
    
    UserPersonalInformation( String name,  String surname,  String mail,  int password){
        Name = name;
        Surname = surname;
        Mail = mail;
        Password = password;
    }
    
    public int GetPassword(){ return Password; }
    public String GetName() { return Name; }
    public String GetSurname() { return Surname; }
    public String GetMail() { return Mail; }


}
