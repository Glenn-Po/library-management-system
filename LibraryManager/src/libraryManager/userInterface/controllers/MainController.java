
package libraryManager.userInterface.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

public class MainController implements Initializable {
    
    private final Map<String, String> pages = new HashMap();
    private final Map<String, String> modalDialogs = new HashMap<>();
    public MainController(){
        super();
        
        //Pages of the application
        pages.put("Welcome", "../views/welcome.fxml");
        pages.put("Login", "../views/login.fxml");
        pages.put("Create Account", "../views/createAccount.fxml");
        pages.put("Recover Password", "../views/recoverpassword.fxml");
        pages.put("User Dashboard", "../views/userDashboard.fxml");
        pages.put("Admin Dashboard", "../views/userDashboard.fxml");
        pages.put("Staff Dashboard", "../views/userDashboard.fxml");
        pages.put("Login", "../views/Login.fxml");
        
        //Modals
        modalDialogs.put("Product Properties", "../views/modalDialogs/software.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
    }
    
    public Parent loadScene(String page){
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
        
        return root;

    }

    
}