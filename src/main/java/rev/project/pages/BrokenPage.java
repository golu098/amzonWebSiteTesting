package rev.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import rev.project.utils.WaitUtils;

import java.util.List;

public class BrokenPage {
    WebDriver driver;

    public BrokenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Wait for the homepage to load completely
    public void waitForPageLoad() {
        WaitUtils.waitForPageLoad(driver);
    }

    // Fetch all links on the page
    public List<WebElement> getAllLinks() {
        return driver.findElements(By.tagName("a"));
    }
}
