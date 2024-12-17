package rev.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistartionPage extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='First and last name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='Mobile number']")
    private WebElement mobileField;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(className = "a-button-input")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(), \"Enter your name\")]")
    private WebElement nameError;

    @FindBy(xpath = "//div[contains(text(), \"Enter your mobile number\")]")
    private WebElement mobileError;

    @FindBy(xpath = "//div[contains(text(), \"Enter your password\")]")
    private WebElement passwordError;
    @FindBy(xpath = "//div[contains(text(), \"Passwords must be at least 6 characters.\")]")
    private WebElement passwordShort;

    public RegistartionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    // Relative locator for nameField
//    WebElement nameError = driver.findElement(
//            RelativeLocator.with(By.className("a-alert-content"))
//                    .below(nameField)
//
//    );
//
//    // Relative locator for mobileField
//    WebElement mobileError = driver.findElement(
//            RelativeLocator.with(By.className("a-alert-content"))
//                    .below(mobileField)
//    );
//
//    // Relative locator for passwordField
//    WebElement passwordError = driver.findElement(
//            RelativeLocator.with(By.className("a-alert-content"))
//                    .below(passwordField)
//    );
    public void loadPage() {
        driver.get("https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    }

    public WebElement getFormLocator() {
        return nameField;
    }

    public void enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterMobile(String mobile) {
        mobileField.clear();
        mobileField.sendKeys(mobile);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getNameError() {
        wait.until(ExpectedConditions.visibilityOf(nameError));
        return nameError.getText();
    }

    public String getMobileError() {
        wait.until(ExpectedConditions.visibilityOf(mobileError));
        return mobileError.getText();
    }

    public String getPasswordError() {
        wait.until(ExpectedConditions.visibilityOf(passwordError));
        return passwordError.getText();
    }

    // Dynamically get field WebElement by name
    public WebElement getFieldByName(String fieldName) {
        return switch (fieldName.toLowerCase()) {
            case "your name" -> nameField;
            case "mobile number" -> mobileField;
            case "password" -> passwordField;
            default -> throw new IllegalArgumentException("Invalid field name: " + fieldName);
        };
    }

    // Dynamically get the error message for a specific field
    public String getErrorForField(String fieldName) {
        return switch (fieldName.toLowerCase()) {
            case "your name" -> getNameError();
            case "mobile number" -> getMobileError();
            case "password" -> getPasswordError();
            default -> throw new IllegalArgumentException("Invalid field name for error: " + fieldName);
        };
    }
    // Dynamically get field WebElement by field name
    public WebElement getFieldElement(String fieldName) {
        return switch (fieldName.toLowerCase()) {
            case "your name" -> nameField;
            case "mobile number" -> mobileField;
            case "password" -> passwordField;
            case "submit button" -> submitButton;
            default -> throw new IllegalArgumentException("Invalid field name: " + fieldName);
        };
    }
    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getPasswordErrorMessage() {
        return passwordShort;
    }
}
