package utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;

public class ServerManager {
    private static final Logger LOGGER = LogManager.getLogger(ServerManager.class);
    AppiumDriverLocalService server;

    public void startAppiumServer() {
        int portNumber = Integer.parseInt(ReadConfigFiles.getPropertyValues("appiumServerPort"));
        String appiumNodePath = ReadConfigFiles.getPropertyValues("appiumNodePath");
        String appiumJsPath = ReadConfigFiles.getPropertyValues("appiumJsPath");
        String serverLog = "logs" + File.separator + ReadConfigFiles.getPropertyValues("appiumServerLog");

        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingPort(portNumber);
        serviceBuilder.usingDriverExecutable(new File(appiumNodePath));
        serviceBuilder.withAppiumJS(new File(appiumJsPath));
        serviceBuilder.withLogFile(new File(serverLog));

        server = AppiumDriverLocalService.buildService(serviceBuilder);
        if (!server.isRunning()) {
            server.start();
        }
        LOGGER.debug("Starting Appium Server..........");
        if(server==null || !server.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started!!");
        }
        LOGGER.info("Appium Server Started");

        server.clearOutPutStreams();
    }

    public void StopAppiumServer() {
        LOGGER.debug("Stopping Appium Server........");
        if (server.isRunning()) {

            server.stop();
        }
        LOGGER.info("Appium Server Stopped");
    }
}
