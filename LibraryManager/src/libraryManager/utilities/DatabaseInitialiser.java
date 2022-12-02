
package libraryManager.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Admin
 */
public class DatabaseInitialiser {
    private final String password;
    private final String username;
    private final String dbURL;
    
    public DatabaseInitialiser(){
        this.dbURL = "ddd";
        this.password = "df";
        this.username = "fg";
    } 
    
    public static Connection getConnection() throws SQLException {
        DatabaseInitialiser dbinit = new DatabaseInitialiser();
        String dbURL = dbinit.dbURL,
               password = dbinit.password,
               username = dbinit.username;
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        
        return connection;
    }
   
}
