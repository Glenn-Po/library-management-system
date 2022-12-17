
package libraryManager.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import libraryManager.utilities.customExceptions.ConfigNotFoundException;

public class System {
    public static System systemInstance;
    private Map<String, String> systemConfigs;

    private System() throws ConfigNotFoundException{
        systemConfigs = new HashMap<>();
        Properties props = new Properties();
        String basePath = java.lang.System.getProperty("user.dir");
        
        //set up the system configurations config
        String configPath = Paths.get(basePath, "src/libraryManager/resources/config.properties").toString();
        try(final InputStream input = new FileInputStream(configPath)){
            props.load(input);
            props.forEach((key, val)->{
                if(key.toString().endsWith("-file")){
                    String cKey = key.toString().replace("-file", "");
                    String path = Paths.get(basePath, val.toString()).toString();
                    systemConfigs.put(cKey, path);
                }
                else systemConfigs.put(key.toString(), val.toString());
            });
            
        }catch(FileNotFoundException e){
            throw new ConfigNotFoundException("Fatal Error: System Configuration file was not found.");
        }catch(IOException e){
            throw new ConfigNotFoundException("Fatal Error: System Configuration file cannot be read.");
        }
    }
    
    private Map<String, String> getConfig(){
        return systemConfigs;
    }
    
    public static System getSystem(){
        if(systemInstance == null){
            try{systemInstance = new System();}
            catch(ConfigNotFoundException e){
                e.printStackTrace();
            }
        }    
        return systemInstance;
    }
    
    public  Map<String, String> getSystemConfig(){   
        return System.getSystem().getConfig();
    }
}
