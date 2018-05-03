package testMain;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import testMain.Config;

import java.net.URISyntaxException;

public class EnvironmentConfig {
    public static String configFile;
    public static final String ENV_PATH = "Environment/";
    public static final String APP_URL = "AppUrl";
    public static final String LOGIN_BASE_URL="LoginBaseUrl";


    protected static XMLConfiguration config = null;

    public static XMLConfiguration getConfig(){
        if(config==null){
            loadConfig();
        }
        return config;
    }
    public static void loadConfig(){
        if(config==null){
            configFile= Config.getEvnProfile()+".xml";
            try {
                config=new XMLConfiguration(loadAndGetResourceLocation(configFile));
            } catch (ConfigurationException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        }
    }
    public static String loadAndGetResourceLocation(String fileName) throws URISyntaxException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(fileName).toString();
    }
    public static String getLoginBaseUrl(){
        return config.getString(ENV_PATH + LOGIN_BASE_URL);
    }

}
