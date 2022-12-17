
package libraryManager.DAO;

import libraryManager.utilities.customExceptions.ConfigNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import libraryManager.utilities.System;

public class DAOFactory {
    private final String password;
    private final String username;
    private final String dbURL;
    private static DAOFactory instance;
    
    private DAOFactory() throws ConfigNotFoundException {
        System system  = System.getSystem();
        this.dbURL = system.getSystemConfig().get("db.url");
        this.password = system.getSystemConfig().get("db.password");
        this.username = system.getSystemConfig().get("db.user");
    }
    
    public static Connection getConnection() {
        try{
            if(instance == null){
                instance = new DAOFactory();
            }  
            String dbURL = instance.dbURL, password = instance.password,
               username = instance.username;
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            return connection;
        }catch(Exception e){ //ConfigNotFoundException or SQLException
            e.printStackTrace();
        }
        return null;
    }
}
