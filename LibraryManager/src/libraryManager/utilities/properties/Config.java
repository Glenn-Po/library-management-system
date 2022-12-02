
package libraryManager.utilities.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import libraryManager.utilities.customExceptions.ConfigNotFoundException;

/**
 *
 * @author glenn-po
 */
public class Config {
    private final Properties props;
    private final String basePath;
    public Config(){
        props = new Properties();
        basePath = System.getProperty("user.dir");
    }
    
    public Map<String, String> getAppConfig() throws ConfigNotFoundException{
        String configPath = Paths.get(basePath, "src/libraryManager/resources/config.properties").toString();
        try(final InputStream input = new FileInputStream(configPath)){
            props.load(input);
            Map<String, String> configs = new HashMap<>();
            props.forEach((key, val)->{
                if(key.toString().endsWith("-file")){
                    String cKey = key.toString().replace("-file", "");
                    String path = Paths.get(basePath, val.toString()).toString();
                    configs.put(cKey, path);
                }
                else configs.put(key.toString(), val.toString());
            });
            
            return configs;
        }catch(FileNotFoundException e){
            throw new ConfigNotFoundException("Fatal Error: Configuration file was not found.");
        }catch(IOException e){
            throw new ConfigNotFoundException("Fatal Error: Configuration file cannot be read.");
        }
    }
    
    
    public Map<String, String> getDBConfig() throws ConfigNotFoundException{
        String dbconfigPath = Paths.get(basePath, "src/libraryManager/resources/dbconfig.properties").toString();
        try(final InputStream input = new FileInputStream(dbconfigPath)){
            props.load(input);
            Map<String, String> dbconfigs = new HashMap<>();
            props.forEach((key, val)->dbconfigs.put(key.toString(), val.toString()));
            return dbconfigs;
        }catch(FileNotFoundException e){
            throw new ConfigNotFoundException("Fatal Error: Database Configuration file was not found.");
        }catch(IOException e){
            throw new ConfigNotFoundException("Fatal Error: Database Configuration file cannot be read.");
        }
    }
}