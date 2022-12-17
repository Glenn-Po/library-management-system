
package libraryManager.userInterface.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraryManager.DAO.AccountDAO;
import libraryManager.models.Account;

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
    
    //Input fields
    @FXML private  TextField
            txtFullName, txtEmail,
            txtPhone, txtUsername;
    @FXML private PasswordField
            pwdPassword, cPassword;
    @FXML private ComboBox<String> cmbSecurityQuestion;
    
    //other
    @FXML private Button btnCreateAccount;
    @FXML private CheckBox cbAcceptTerms;
    @FXML private ProgressIndicator progressIndex;
    
    
    private final MainController controller;
    private final AccountDAO accountDAO;
    
    public CreateAccountController(){
        controller = new MainController();
        accountDAO = new AccountDAO();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       cmbSecurityQuestion.getItems().addAll(
            "What is your favourite color?",
             "What is your Pets name?",
             "What is your grandpa's middle name?"
        );
       
       linkLogin.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setTitle("Kingston Library -  Log In.");
               stage.getScene().setRoot(controller.loadScene("Login"));
               stage.setResizable(true);
               stage.setMaximized(true);
           }
       });
       
       btnCreateAccount.setOnAction(event->{
//           boolean success = this.createAccount();
//           progressIndex.setVisible(false);
//           if (!success)return;
           Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           stage.setTitle("Kingston Library -  Dashboard");
           stage.getScene().setRoot(controller.loadScene("User Dashboard"));
       });
        
    }  
    
    boolean createAccount(){
        String fullName, email, phone, username,password, cpassword,
                securityQuestion, securityAnswer;
        fullName = txtFullName.getText();
        email    = txtEmail.getText();
        phone    = txtPhone.getText();
        username = txtUsername.getText();
        password = pwdPassword.getText();
        cpassword= cPassword.getText();
        securityQuestion = cmbSecurityQuestion.getValue();
        securityAnswer   = "Jackson";
        //check if user agreement is checked
        if(!cbAcceptTerms.isSelected()){
            new Alert(Alert.AlertType.WARNING, "You have to accept the Terms of Services to progress").showAndWait();
            return false;
        }
        //check if recovery question exists
        //start indeterminate progress indicator
        progressIndex.setVisible(true);
        //check if passwords match
        if(password == cpassword){
            new Alert(Alert.AlertType.ERROR, "Your passwords don't match.").showAndWait();
            return false;
        }
        
        if (password.length() < 8){
            new Alert(Alert.AlertType.ERROR, "Your password is too short.").showAndWait();
            return false;
        }
        //check if email and number are valid
        //hash password
        
        //create account model
//        Account account = new Account(6, username, password, "ACTIVE", 
//                                        securityQuestion, securityAnswer);
//
//        //update account in database
//        new AccountDAO().create(account);
        //all done
        progressIndex.setVisible(false);
        return true;
    }
    
}
