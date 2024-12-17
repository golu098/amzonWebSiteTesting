package rev.project.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import rev.project.driver.BrowserType;
import rev.project.driver.DriverManager;
import rev.project.utils.ScreenshotUtil;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
WebDriver driver;
    public WebDriver getDriver() {
        return driver; // Return the current driver instance
    }

    @Before
    public void setUp() {
//        String browser = System.getProperty("browser", "CHROME").toUpperCase();
//        driver = DriverManager.getDriver(BrowserType.valueOf(browser)); // Assign the WebDriver to the 'driver' field
        ChromeOptions options=new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://10.71.162.198:4444"), options);
        }
        catch (MalformedURLException e){
            throw new RuntimeException("Invalid URL for Remote WebDriver",e);
        }
    }


    @After
    public void tearDown(Scenario scenario) {
        String browser = System.getProperty("browser", "CHROME").toUpperCase();
        if (scenario.isFailed()) {
            String screenshotPath = ScreenshotUtil.takeScreenshot(DriverManager.getDriver(BrowserType.valueOf(browser)), scenario.getName());
            // You can also log or store the screenshot path if needed
        }
        DriverManager.quitDriver();
    }
}
