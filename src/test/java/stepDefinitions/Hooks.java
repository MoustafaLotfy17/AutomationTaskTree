package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import managers.DriverManager;
import managers.FileReaderManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import runner.Runner;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.time.Duration;

public class Hooks extends DriverManager {

    @Before
    public static void before() {

        if (FileReaderManager.getInstance().getConfigReader().getEnvironment().equals("local")) {
            setDriver(FileReaderManager.getInstance().getConfigReader().getBrowser());
        } else {
            // Define remote web-driver capabilities
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPlatformName("LINUX");
            edgeOptions.setBrowserVersion("111.0");

            // Define the remote webdriver URL
            String remoteURL = "http://" + System.getProperty("host") + ":" + System.getProperty("port") + "/wd/hub";
            System.out.println("remote url is: " + remoteURL);

            // Initialize the RemoteWebdriver instance
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);

            try {
                setDriver(remoteURL, desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait()));
    }

    @After
    public static void After() {

        try {
            // Take a screenshot and save it to Allure report
            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));

            // Close the browser window
            if (getDriver() != null) {
                removeDriver();
            }
            Allure.step("Successfully closed the Webdriver instance.");
        } catch (Exception e) {
            Allure.step("Failed to close the Webdriver instance: " + e.getMessage());
        }
    }
}
