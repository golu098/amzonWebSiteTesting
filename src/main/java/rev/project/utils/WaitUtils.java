package rev.project.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_WAIT_TIME = 100;

    // General method to wait for an element to be visible on the page
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    // Wait until the element is visible
    public static WebElement waitForVisibilityOfElement(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    // Wait until the element is clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait until the element is present in the DOM
    public static WebElement waitForElementPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static Alert waitForAlert(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    // Wait until the element is invisible
    public static boolean waitForElementToBeInvisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait until the element is stale (no longer attached to the DOM)
    public static boolean waitForElementToBeStale(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.stalenessOf(element));
    }

    // Wait for a specific attribute value of an element
    public static boolean waitForElementAttribute(WebDriver driver, By locator, String attribute, String value, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
    }

    // Wait for a custom JavaScript condition (e.g., waiting for page load or a specific JS variable)
    public static boolean waitForJavaScriptCondition(WebDriver driver, String script, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript(script).equals(true));
    }

    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Default wait method for clickable elements
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return waitForElementToBeClickable(driver, locator, DEFAULT_WAIT_TIME);
    }

    // Default wait method for element presence
    public static WebElement waitForElementPresence(WebDriver driver, By locator) {
        return waitForElementPresence(driver, locator, DEFAULT_WAIT_TIME);
    }

    // Custom wait for a text to be present in an element
    public static boolean waitForTextToBePresentInElement(WebDriver driver, By locator, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Default wait method for element invisibility
    public static boolean waitForElementToBeInvisible(WebDriver driver, By locator) {
        return waitForElementToBeInvisible(driver, locator, DEFAULT_WAIT_TIME);
    }

    // Default wait method for element staleness
    public static boolean waitForElementToBeStale(WebDriver driver, WebElement element) {
        return waitForElementToBeStale(driver, element, DEFAULT_WAIT_TIME);
    }

    // Default wait method for element attribute
    public static boolean waitForElementAttribute(WebDriver driver, By locator, String attribute, String value) {
        return waitForElementAttribute(driver, locator, attribute, value, DEFAULT_WAIT_TIME);
    }

    // Default wait method for JavaScript condition
    public static boolean waitForJavaScriptCondition(WebDriver driver, String script) {
        return waitForJavaScriptCondition(driver, script, DEFAULT_WAIT_TIME);
    }
    // Wait until the page is fully loaded
    public static boolean waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    // Default page load wait
    public static boolean waitForPageLoad(WebDriver driver) {
        return waitForPageLoad(driver, DEFAULT_WAIT_TIME);
    }

}
