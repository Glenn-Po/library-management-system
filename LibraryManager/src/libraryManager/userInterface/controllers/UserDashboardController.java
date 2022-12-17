package libraryManager.userInterface.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class UserDashboardController implements Initializable {
    
    /*Sidebar menu buttons**/
    @FXML
    private Button btnLoanBook,
            btnHome,
            btnProfile,
            btnBooks,
            btnWishlist,
            btnActions;
    @FXML
    private AnchorPane rootPane;
    private Button selectedMenuButton;
    
    private final String ACTIVE_MENU_CLASS = "active";
    public UserDashboardController(){
                
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectedMenuButton = btnHome;
        selectedMenuButton.getStyleClass().add(ACTIVE_MENU_CLASS);
        Map<Button, String> mapDisplay = new HashMap<>();
        mapDisplay.put(btnHome, "../views/components/userDashboard-Home.fxml");
        mapDisplay.put(btnProfile, "../views/components/userDashboard-Profile.fxml");
        mapDisplay.put(btnBooks, "../views/components/userDashboard-MyBooks.fxml");
        mapDisplay.put(btnActions, "../views/components/userDashboard-Actions.fxml");
        for(Button btn : new Button[]{btnHome, btnProfile, btnBooks, btnWishlist, btnActions}){
            btn.setOnAction(event->{
                selectedMenuButton.getStyleClass().remove(ACTIVE_MENU_CLASS);
                selectedMenuButton = btn;
                selectedMenuButton.getStyleClass().add(ACTIVE_MENU_CLASS);
                try{
                    System.out.println(new File(mapDisplay.get(btn)).exists());
                    URL compURL = getClass().getResource(mapDisplay.get(btn));
                    Parent root = FXMLLoader.load(compURL);
                    rootPane.setTopAnchor(root, 0.0);
                    rootPane.setBottomAnchor(root, 0.0);
                    rootPane.setRightAnchor(root, 0.0);
                    rootPane.setLeftAnchor(root,0.0);
                    rootPane.getChildren().add(root);
                }catch(IOException e){
                    String errorMessage = "The page you are tring to access in this application has failed to load. Contact support for "
                    + "this problem to be resolved.";
                    new Alert(Alert.AlertType.ERROR, errorMessage).showAndWait();
                    System.out.println(e.getMessage());
                }
            });
        }
    }
    
    void clickMenu(){
        
    }
    
}
