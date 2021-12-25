package utilities;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;

public class CapabilitiesManager {
    private static final Logger LOGGER = LogManager.getLogger(CapabilitiesManager.class);

    public DesiredCapabilities getCaps() {
        String deviceName = ReadConfigFiles.getPropertyValues("deviceName");
        String udID = ReadConfigFiles.getPropertyValues("udId");
        String automationName = ReadConfigFiles.getPropertyValues("androidAutomationName");
        String appPackage = ReadConfigFiles.getPropertyValues("androidAppPackage");
        String appActivity = ReadConfigFiles.getPropertyValues("androidAppActivity");
        String appName = ReadConfigFiles.getPropertyValues("androidAppName");
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "apps" + File.separator + appName;
        LOGGER.debug("App Location is:" +appPath);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,udID);
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, appName);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);

        return desiredCapabilities;

    }
}
