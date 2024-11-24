package rev.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

interface Driver {
    WebDriver createDriver();
}

class ChromeDriverSupplier implements Driver {
    @Override
    public WebDriver createDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

class FireFoxDriverSupplier implements Driver {
    @Override
    public WebDriver createDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

class EdgeDriverSupplier implements Driver {
    @Override
    public WebDriver createDriver() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    private static Driver getDriverSupply(BrowserType type) {
        switch (type) {
            case CHROME:
                return new ChromeDriverSupplier();
            case EDGE:
                return new EdgeDriverSupplier();
            case FIREFOX:
                return new FireFoxDriverSupplier();
            default:
                throw new IllegalArgumentException("This browser is not supported");
        }
    }

    // Thread-local driver for each thread (useful in parallel testing)
    public synchronized static WebDriver getDriver(BrowserType type) {
        if (driver.get() == null) {
            driver.set(getDriverSupply(type).createDriver());
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
