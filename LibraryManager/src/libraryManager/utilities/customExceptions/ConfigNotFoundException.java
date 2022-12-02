
package libraryManager.utilities.customExceptions;

/**
 *
 * @author Admin
 */
public class ConfigNotFoundException extends Exception {
     String error;
    public ConfigNotFoundException(){
        super();
        error = null;
    }
    
    public ConfigNotFoundException(String message){
        super();
        error = message;
    }
    
    @Override
    public String getMessage(){
        if(error != null)
            return error;
        return "There was a fatal error reading the configuration for this application.";
    }
}
