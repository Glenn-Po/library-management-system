
package libraryManager.userInterface.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author glenn-po
 */
public class WelcomeController implements Initializable {

    @FXML
    private Button  btnCreateAccount;
    
    @FXML
    private Button btnLogin;
    
    private MainController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       controller = new MainController();
       
       btnLogin.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setTitle("Kingston Library -  Log In.");
               stage.getScene().setRoot(controller.loadScene("Login"));
               stage.setResizable(true);
               stage.setMaximized(true);
           }
       });
               
       btnCreateAccount.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               Stage stage = (Stage)(btnCreateAccount.getScene().getWindow());
               stage.setTitle("Kingston Library -  Create your account.");
               stage.setResizable(true);
               stage.getScene().setRoot(controller.loadScene("Create Account"));
               stage.setResizable(true);
               stage.setMaximized(true);
           }
       }
               
       );
    }    
    
    public void gotoLogin(){
        System.out.println("Logging In");
    }
    
    public void gotoCreateAccount(){
        System.out.println("Going to create account");
    }
}
