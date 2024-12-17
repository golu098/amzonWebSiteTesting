package rev.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rev.project.utils.ConfigUtils;

import java.time.Duration;
import java.util.Set;

public class ProductDetailsPage {
    WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set explicit wait timeout
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;



    @FindBy(xpath = "//span[@class='a-price-whole']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@id='availability']//span")
    private WebElement availabilityStatus;

    @FindBy(id = "acrCustomerReviewText")
    private WebElement customerReviews;

    // Methods
    public void navigateToHomePage() {
        String url = ConfigUtils.accessUrl("homepage.url");
        driver.get(url); // Navigate to Amazon home page
    }

    public void searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void clickOnSearchResultContainingProductName(String productName) {
        // Use dynamic XPath to find the product that contains the provided product name
        String dynamicXPath = "//span[contains(text(), '" + productName + "')]";

        // Wait for the element to be clickable and then click on it
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
        product.click();

        // Get the current window handle (the main window)
        String mainWindowHandle = driver.getWindowHandle();

        // Switch to the new window (the new tab)
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle); // Switch to the new tab
                break;
            }
        }

        // Wait for the new window/tab to load, you can add specific waits here for elements in the new window
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath))); // Example of waiting for product title in the new tab
    }
    public WebElement getProductTitle(String productName) {
        // Construct dynamic XPath based on the product name
        String dynamicXPath = "//span[contains(text(), '" + productName + "')]";
        return driver.findElement(By.xpath(dynamicXPath));
    }

    public String getProductName(String productName) {
        String dynamicXPath = "//span[contains(text(), '" + productName + "')]";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath))).getText();
    }

    public boolean isPriceDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(productPrice)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAvailabilityDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(availabilityStatus)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasCustomerReviews() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(customerReviews)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
