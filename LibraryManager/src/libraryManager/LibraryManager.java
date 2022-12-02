
package libraryManager;

/**
 *
 * @author glenn-po
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import libraryManager.userInterface.controllers.MainController;
import libraryManager.utilities.properties.Config;

public class LibraryManager extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            
            System.out.println("\n*** Welcome to Library Management Syste***\n");
            Config config = new Config();
            primaryStage.setTitle("Kingston Library -  Welcome");
            primaryStage.getIcons().add(new Image(config.getAppConfig().get("window-icon")));
            
            MainController controller = new MainController();
            Scene scene = controller.loadScene("Welcome");
            
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.show(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        
        launch(args);
    }
}

