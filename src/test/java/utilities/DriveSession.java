package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriveSession {
    public static void driverSession(String deviceName, String udId, String appPath) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udId);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);
        desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
        desiredCapabilities.setCapability("appActivity" , "io.appium.android.apis.ApiDemos");
        desiredCapabilities.setCapability("avd", "Pixel 5");
        desiredCapabilities.setCapability("avdLaunchTimeout", 180000);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        AppiumDriver driver = new AndroidDriver(url, desiredCapabilities);
    }
}
