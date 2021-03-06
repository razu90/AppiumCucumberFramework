package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {
    private DriverFactory() {
    }

    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);
    private static final DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<AppiumDriver> driver = ThreadLocal.withInitial(() -> {
        URL url= null;

        try {
            url = new URL(ReadConfigFiles.getPropertyValues("appiumURL"));
            LOGGER.info("Appium URL is:" + url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        CapabilitiesManager capabilitiesManager = new CapabilitiesManager();
        return new AndroidDriver(url, capabilitiesManager.getCaps());
    });
    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }

}
