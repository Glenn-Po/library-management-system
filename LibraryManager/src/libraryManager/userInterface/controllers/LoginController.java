
package libraryManager.userInterface.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LoginController implements Initializable {
    
    @FXML
    private Hyperlink linkCreateAccount;
    
    private final MainController controller;
    
    public LoginController(){
        controller = new MainController();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        linkCreateAccount.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               Stage stage = (Stage)(linkCreateAccount.getScene().getWindow());
               stage.setTitle("Kingston Library -  Create your account.");
               stage.setResizable(true);
               stage.setScene(controller.loadScene("Create Account"));
               stage.setResizable(true);
               stage.setMaximized(true);
           }
       });
    }

    
    void login(){
        
    }
    
}
