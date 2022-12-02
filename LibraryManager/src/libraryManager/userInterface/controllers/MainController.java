
package libraryManager.userInterface.controllers;

/**
 *
 * @author glenn-po
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MainController implements Initializable {
    
    private final Map<String, String> pages = new HashMap();
    private final Map<String, String> components = new HashMap<>();
    
    public MainController(){
        super();
        
        //Pages of the application
        pages.put("Welcome", "../views/welcome.fxml");
        pages.put("Login", "../views/login.fxml");
        pages.put("Create Account", "../views/createAccount.fxml");
        pages.put("Recover Password", "../views/recoverpassword.fxml");
        pages.put("Login", "../views/Login.fxml");
        pages.put("Login", "../views/Login.fxml");
        pages.put("Login", "../views/Login.fxml");
        pages.put("Login", "../views/Login.fxml");
        
        //components in the application
        // |-> Window like components
        components.put("Error PopUp", "../views/components/errorpopup.fxml");
        components.put("Warning PopUp", "../views/components/errorpopup.fxml");
        components.put("Success PopUp", "../views/components/errorpopup.fxml");
        
        // |-> Subview components
        components.put("Sidebar", "../views/components/errorpopup.fxml");
        components.put("Menubar", "../views/components/errorpopup.fxml");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
    }
    
    public Scene loadScene(String page){
        Parent root = null;
        try{
            String path = pages.get(page);
            URL pageViewUrl = getClass().getResource(path);
            root = FXMLLoader.load(pageViewUrl);
        }catch(IOException e){
            String errorMessage = "The page you are tring to access in this application has failed to load. Contact support for "
                    + "this problem to be resolved.";
            new Alert(Alert.AlertType.ERROR, errorMessage).showAndWait();
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        return new Scene(root);

    }

    
}