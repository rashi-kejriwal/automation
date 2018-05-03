package testMain;

import net.liftweb.http.js.JE;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.Properties;

public class Config {
    public static final String ENVIRONMENT_PROFILE = "environment.profile";
    private static String configFile = "testMain.Config.properties";
    public static Configuration configuration;
    private Config(){

    }
    public static Configuration getInstance(){
        if(configuration==null){
            try {
                configuration=new PropertiesConfiguration(loadAndGetResourceLocation(configFile));
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }
        return configuration;
    }
    public static void loadConfig(){
        getInstance();
    }
    public static String loadAndGetResourceLocation(String fileName){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(fileName).toString();
    }

    public static String getEvnProfile(){
        return configuration.getString(ENVIRONMENT_PROFILE);
    }
}
