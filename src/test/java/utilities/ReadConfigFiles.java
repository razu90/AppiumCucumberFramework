package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class ReadConfigFiles {
    private static final Logger LOGGER = LogManager.getLogger(ReadConfigFiles.class);

    public static String getPropertyValues(String propName) {
        Properties properties;
        String propValue  = null;
        try {
            properties = new LoadConfigFiles().readPropertyValues();
            propValue = properties.getProperty(propName);
        } catch (Exception e) {
            LOGGER.error("Exception in getPropertyValues is:" +e.getMessage());
        }
        return propValue;
    }
}
