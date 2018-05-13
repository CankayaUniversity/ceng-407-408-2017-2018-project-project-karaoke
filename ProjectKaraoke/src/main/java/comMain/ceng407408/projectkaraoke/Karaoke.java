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

import java.sql.*;
import java.util.Scanner;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.PropertyExpander;
import java.util.ArrayList;
import javafx.scene.Scene;
import comMain.ceng407408.projectkaraoke.UserInfo;
import java.util.List;

public class Karaoke {

    /**
     * @param args the command line arguments
     */
    private Connection con;

    static Scanner sc = new Scanner(System.in);

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DOMAIN_NAME = "localhost";
    static final String DB_NAME = "karaoke";
    static final String DB_URL = "jdbc:mysql://localhost:3306/karaoke?zeroDateTimeBehavior=convertToNull";

    static final String USER = "root";
    static final String PASS = "";

    public Karaoke() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection successful!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public int CreateUser(String name, String surname, String mail, int password) {

        PreparedStatement psmt = null;
        int result;

        try {

            psmt = con.prepareStatement("SELECT * FROM user_types WHERE Mail = ?");
            psmt.setString(1, mail);
            ResultSet resultset = psmt.executeQuery();

            if (!resultset.next()) {

                psmt = con.prepareStatement("INSERT INTO user_types (Name, Surname, Mail, Password, IsActive,IsAdmin) VALUES (?,?,?,?,?,?)");
                psmt.setString(1, name);
                psmt.setString(2, surname);
                psmt.setString(3, mail);
                psmt.setInt(4, password);
                psmt.setInt(5, 1);
                psmt.setInt(6,0);
                psmt.executeUpdate();
                result=1;
             
            } else {
                result=2;
             
            }
            psmt.close();
            resultset.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            result=0;

        }
        return result;
    }

    public int DeleteUser(String mail) {

        int flag = 1;
        PreparedStatement psmt = null;
        int returnresult=100;

        try {
            psmt = con.prepareStatement("SELECT IsActive FROM user_types WHERE Mail = ?");
            psmt.setString(1, mail);
            ResultSet resultset = psmt.executeQuery();
            while (resultset.next()) {
                if (resultset.getBoolean("IsActive") == false) {
                    flag = 0;
                    returnresult=2;
                }
            }

            if (flag != 0) {
                psmt = con.prepareStatement("UPDATE user_types SET IsActive = ? WHERE Mail = ?");
                psmt.setInt(1, 0);
                psmt.setString(2, mail);
                int result = psmt.executeUpdate();
                if (result != 0) {
                    returnresult=1;
                } else {
                    returnresult=0;
                }
            }
            psmt.close();
            resultset.close();
            

        } catch (Exception ex) {

            ex.printStackTrace();

        }
        return returnresult;
    }

    public int AddSong(String songname, String lyric) {

        PreparedStatement psmt = null;
        int returnresult=100;

        int ID = 0;
               try {
            psmt = con.prepareStatement("INSERT INTO song_main (SongName, Lyric, IsActive) VALUES (?,?,?)");
            psmt.setString(1, songname);
            psmt.setString(2, lyric);
            psmt.setInt(3, 1);
            int result = psmt.executeUpdate();
            if (result != 0) {
                returnresult=1;
            } else {
                returnresult=0;
            }

            psmt.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }
        try {
            psmt = con.prepareStatement("SELECT SongID FROM song_main ORDER BY SongID DESC LIMIT 1");

            ResultSet resultset = psmt.executeQuery();
            if (resultset.next()) {

                ID = resultset.getInt("SongID");

            }

            psmt.close();
            resultset.close();
        } catch (Exception ex) {

            ex.printStackTrace();

        }
        try {

            psmt = con.prepareStatement("INSERT INTO song_count (SongID, WordLocationID, Word) VALUES (?,?,?)");

            String[] words = lyric.split(" ");
            int counter = words.length;
            int wordlocationid = ID + 1;
            for (int i = 0; i < counter; i++) {
                System.out.println(words[i]);
                psmt.setInt(1, ID);
                psmt.setInt(2, wordlocationid);
                psmt.setString(3, words[i]);
                wordlocationid++;
                psmt.executeUpdate();

            }
            psmt.close();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return returnresult;

    }

    public int Login(String mail, int password) {

        PreparedStatement psmt = null;
        int returnresult=100;
        try {
            psmt = con.prepareStatement("SELECT * FROM user_types WHERE ((Mail = ? && Password = ?) && IsActive = ?)");
            psmt.setString(1, mail);
            psmt.setInt(2, password);
            psmt.setInt(3, 1);
            ResultSet resultset = psmt.executeQuery();
            if (resultset.next()) {

                System.out.println(resultset.getString("Name"));
                returnresult = 1;

            } else {
                psmt = con.prepareStatement("SELECT IsActive FROM user_types WHERE Mail = ? && Password = ?");
                psmt.setString(1, mail);
                psmt.setInt(2, password);
                resultset = psmt.executeQuery();
                if (!resultset.next()) {
                    System.out.println("Wrong Mail or Password!");
                    returnresult=0;
                } else {
                    if (resultset.getInt("IsActive") == 0) {
                        System.out.println("User Is Not Active!");
                        returnresult=2;
                    }

                }

            }
            psmt.close();
            resultset.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }
        return returnresult;
    }

    private void ViewSongList() {

        PreparedStatement psmt = null;

        try {

            psmt = con.prepareStatement("SELECT * FROM song_main WHERE IsActive = ?");
            psmt.setInt(1, 1);
            ResultSet resultset = psmt.executeQuery();
            if (resultset.next()) {
                System.out.println(resultset.getString("SongName"));

                while (resultset.next()) {
                    System.out.println(resultset.getString("SongName"));

                }
            } else {
                System.out.println("There Is No Song In Database!");
            }

            psmt.close();
            resultset.close();
        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }

    private void DeleteSong() {

        int flag = 1;
        PreparedStatement psmt = null;

        System.out.println("Enter Name Of Song That You Want To Delete:");
        String buffer = sc.nextLine();
        String songname = sc.nextLine();
        try {
            psmt = con.prepareStatement("SELECT IsActive FROM song_main WHERE SongName = ?");
            psmt.setString(1, songname);
            ResultSet resultset = psmt.executeQuery();
            while (resultset.next()) {
                if (resultset.getBoolean("IsActive") == false) {
                    System.out.println("Song Is Not Active!");
                    flag = 0;
                }
            }

            if (flag != 0) {
                psmt = con.prepareStatement("UPDATE song_main SET IsActive = ? WHERE SongName = ?");
                psmt.setInt(1, 0);
                psmt.setString(2, songname);
                int result = psmt.executeUpdate();
                if (result != 0) {
                    System.out.println("Delete Song From Database Successfully! ");
                } else {
                    System.out.println("There Is No Song With " + songname + " Name");
                }
            }
            psmt.close();
            resultset.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }

    public ArrayList<UserInfo> ViewSinger(int user) {

        PreparedStatement psmt = null;
        ArrayList<UserInfo> listSinger = new ArrayList<UserInfo>();
        try {
            psmt = con.prepareStatement("SELECT * FROM singer WHERE UserID = ? && IsActive = ?");
            psmt.setInt(1, user);
            psmt.setInt(2, 1);
            ResultSet resultset = psmt.executeQuery();
            if (resultset.next()) {
                listSinger.add(new UserInfo(user, resultset.getString("SingerName"), resultset.getString("SingerSurname"), resultset.getFloat("AverageScore")));
                while (resultset.next())
                    listSinger.add(new UserInfo(user, resultset.getString("SingerName"), resultset.getString("SingerSurname"), resultset.getFloat("AverageScore")));
            } /*else {
                psmt = con.prepareStatement("SELECT IsActive FROM singer WHERE UserID = ?");
                psmt.setInt(1, user);
                resultset = psmt.executeQuery();
                if (!resultset.next()) {
                    System.out.println("There Is No Singer!");
                } else {

                    if (resultset.getInt("IsActive") == 0) {
                        System.out.println("Singer Is Not Active!");
                    }

                }

            }*/
            psmt.close();
            resultset.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }
        return listSinger;
    }

    private void DeleteSinger() {

        PreparedStatement psmt = null;
        System.out.println("UserID:");
        int user = sc.nextInt();

        try {
            psmt = con.prepareStatement("SELECT * FROM singer WHERE UserID = ? && IsActive = ?");
            psmt.setInt(1, user);
            psmt.setInt(2, 1);
            ResultSet resultset = psmt.executeQuery();
            if (resultset.next()) {
                System.out.println(resultset.getInt("SingerID"));
                System.out.println(resultset.getString("SingerName"));
                System.out.println(resultset.getString("SingerSurname"));

                while (resultset.next()) {
                    System.out.println(resultset.getInt("SingerID"));
                    System.out.println(resultset.getString("SingerName"));
                    System.out.println(resultset.getString("SingerSurname"));

                }
                System.out.println("Enter ID Of Singer That You Want To Delete:");
                int ID = sc.nextInt();
                try {
                    psmt = con.prepareStatement("UPDATE singer SET IsActive = ? WHERE SingerID = ?");
                    psmt.setInt(1, 0);
                    psmt.setInt(2, ID);
                    int result = psmt.executeUpdate();
                    if (result != 0) {
                        System.out.println("Delete Singer From Database Successfully! ");
                    } else {
                        System.out.println("There Is No User With " + ID + " ID!");
                    }

                    psmt.close();

                } catch (Exception ex) {

                    ex.printStackTrace();

                }
            } else {

                System.out.println("There Is No Singer!");

            }
            psmt.close();
            resultset.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    private void AddSinger() {

        PreparedStatement psmt = null;

        System.out.println("UserID:");
        int user = sc.nextInt();
        System.out.println("Enter Name Of Singer:");
        String name = sc.next();
        System.out.println("Enter Surname Of Singer:");
        String surname = sc.next();

        try {

            psmt = con.prepareStatement("INSERT INTO singer (SingerName, SingerSurname, IsActive, AverageScore,UserID) VALUES (?,?,?,?,?)");
            psmt.setString(1, name);
            psmt.setString(2, surname);
            psmt.setInt(3, 1);
            psmt.setFloat(4,0);
            psmt.setInt(5, user);
            psmt.executeUpdate();
            System.out.println("Singer Inserted Successfully! ");

            psmt.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }

 
}

