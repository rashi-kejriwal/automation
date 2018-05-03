package testMain;

import org.apache.commons.configuration.XMLConfiguration;
import testMain.EnvironmentConfig;

public class PartnerConfig {
    public static final String PARTNER_PATH = "Partners/";
    public static XMLConfiguration config = EnvironmentConfig.getConfig();
    public static String getPartnerNameFor(String partnerId) {
        return config.getString(PARTNER_PATH + partnerId + "/Name");
    }
}
