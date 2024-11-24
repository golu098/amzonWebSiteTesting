package rev.project.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import rev.project.driver.BrowserType;
import rev.project.driver.DriverManager;

public class Hooks {

    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }

    @Before
    public void setUp() {
        driver = DriverManager.getDriver(BrowserType.CHROME);
        System.out.println("Driver initialized");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            DriverManager.quitDriver();
            System.out.println("Driver quit");
        }
    }
}
