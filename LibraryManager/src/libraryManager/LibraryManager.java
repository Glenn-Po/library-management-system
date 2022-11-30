
package libraryManager;

/**
 *
 * @author glenn-po
 */
//public class LibraryManager {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        
//        System.out.println(" ***Welcome to the Library Management System*** ");
//    }
//    
//}


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LibraryManager extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            String xmlCode = `"C:\Users\Admin\Desktop\jtest\test-login.fxml"`;
            Parent root = FXMLLoader.load(getClass().getResource(xmlCode));
            primaryStage.setTitle("KeepToo SMSys");
            primaryStage.getIcons().add(new Image("/home/icons/icon.png"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

