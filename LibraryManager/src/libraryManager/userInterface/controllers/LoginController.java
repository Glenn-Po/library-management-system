
package libraryManager.userInterface.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import libraryManager.DAO.AccountDAO;


public class LoginController implements Initializable {
    
    @FXML
    private Hyperlink linkCreateAccount;
    
    @FXML
    private Button btnLogin;
    
    //inputs
    @FXML 
    private TextField txtID, txtUSername;
    @FXML private PasswordField pwdPassword;
    
    private final MainController controller;
    private final AccountDAO accountDAO;
    public LoginController(){
        controller = new MainController();
        accountDAO = new AccountDAO();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        linkCreateAccount.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();//(Stage)(linkCreateAccount.getScene().getWindow());
               stage.setTitle("Kingston Library -  Create your account.");
//               stage.setResizable(true);
               stage.getScene().setRoot(controller.loadScene("Create Account"));
               Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
               stage.setMaximized(true);
               stage.setX(screenBounds.getMinX());
               stage.setY(screenBounds.getMinY());
               stage.setWidth(screenBounds.getWidth());
               stage.setHeight(screenBounds.getHeight());
               stage.setResizable(true);
               stage.setMaximized(true);
           }
       });
        
        btnLogin.setOnAction(event->{
            boolean success = this.login();
            if(!success){
                return;
            }
           Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           stage.setTitle("Kingston Library -  Dashboard");
           stage.getScene().setRoot(controller.loadScene("User Dashboard"));
           stage.setResizable(true);
           stage.setMaximized(true);
        });
    }

    
    boolean login(){
        String loginID, username, password;
        loginID = txtID.getText();
        username = txtUSername.getText();
        password = pwdPassword.getText();
        
        
        //Validation
        //1. Empty fields
        if(loginID.equals("") || username.equals("") || password.equals("")){
            new Alert(Alert.AlertType.WARNING, "Fill in values for all fields").showAndWait();
            return false;
        }
        
        //existing username
        boolean usernameExists = accountDAO.existUsername(username);
        if(!usernameExists){
            new Alert(Alert.AlertType.WARNING, "YThis username already exists. ").showAndWait();
            return false;
        }
        //existing username-password combination
        
        return true;
    }
}
