
package libraryManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import libraryManager.userInterface.controllers.MainController;

public class LibraryManager extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            
            System.out.println("\n*** Welcome to Library Management System***\n");
            
            libraryManager.utilities.System system  = libraryManager.utilities.System.getSystem();
            primaryStage.setTitle("Kingston Library -  Welcome");
            primaryStage.getIcons().add(new Image(system.getSystemConfig().get("window-icon")));
            
            MainController controller = new MainController();
            Scene scene = new Scene(controller.loadScene("Welcome"));
            
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

