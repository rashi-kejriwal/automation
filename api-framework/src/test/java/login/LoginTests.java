package login;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testMain.Config;
import testMain.EnvironmentConfig;


public class LoginTests {
    @BeforeTest
    public void load(){
        Config.loadConfig();
        EnvironmentConfig.loadConfig();
    }
    @Test
    public void loginCheck(){

    }
    @DataProvider
    public Object[][] users(){
        return new Object[][] {{"rashi.kejriwal@sprinklr.com","Test#123"}};
    }
}
