
package libraryManager.userInterface.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author glenn-po
 */
public class CreateAccountController implements Initializable {

    @FXML
    private Hyperlink linkLogin;
    
    @FXML
    private Hyperlink linkRecoverPassword;
    
    private final MainController controller;
    
    public CreateAccountController(){
        controller = new MainController();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       linkLogin.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setTitle("Kingston Library -  Log In.");
               stage.setScene(controller.loadScene("Login"));
               stage.setResizable(true);
               stage.setMaximized(true);
           }
       });
        
    }    
    
}
