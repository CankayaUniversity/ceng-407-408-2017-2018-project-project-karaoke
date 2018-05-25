/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comMain.ceng407408.projectkaraoke;

import UserStatic.UserSession;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author mehmetali
 */
public class TeacherMain implements Initializable {
    
    @FXML TableView<UserAbst> tableviewListOfSingers = new TableView<UserAbst>();
    @FXML Button buttonScoreTable = new Button();
    @FXML Button buttonAddStudent = new Button();
    @FXML Button buttonStartKaraoke = new Button();    
    private final Karaoke objMainFunc = new Karaoke();
    
    public void funcScoreTable() throws SQLException{
        
    }
    
    public void funcAddStudent(){
        
    }
    public void funcStartKaroke(){
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            objMainFunc.funcListSinger(tableviewListOfSingers);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherMain.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
    

    public static void main(String[] args) {
        launch(args);
    }
}
