package rev.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddToCartPage extends BasePage {
    WebDriver driver;
    private WebDriverWait wait;
    // Constructor
    public AddToCartPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set explicit wait timeout
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class=\"a-section a-spacing-none puis-padding-right-small s-title-instructions-style\"]")
    private List<WebElement> searchResults;

    @FindBy(id = "a-autoid-1-announce")
    private WebElement addToCartButton;

    @FindBy(xpath = "//h4[contains(text(),'Added to cart')]")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//a[contains(@class, \"a-button-text\")]")
    private WebElement cartButton;

    @FindBy(xpath = "//h4[@class=\"a-text-normal\"]")
    private List<WebElement> cartProductNames;

    @FindBy(xpath = "//div[@class=\"a-declarative\"]")
    private List<WebElement> cartProductQuantities;

    @FindBy(xpath = "//span[@class=\"a-size-medium a-color-base sc-price sc-white-space-nowrap\"]")
    private WebElement totalItemsLabel;

    // Actions
    public void searchForProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void selectProductFromResults(String productName) {
        for (WebElement result : searchResults) {
            if (result.getText().equalsIgnoreCase(productName)) {
                result.click();
                break;
            }
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public boolean isConfirmationMessageDisplayed(String expectedMessage) {
        return confirmationMessage.isDisplayed() && confirmationMessage.getText().contains(expectedMessage);
    }

    public void goToCartPage() {
        cartButton.click();
    }

    public boolean isProductInCart(String productName, int expectedQuantity) {
        for (int i = 0; i < cartProductNames.size(); i++) {
            if (cartProductNames.get(i).getText().equalsIgnoreCase(productName)) {
                int actualQuantity = Integer.parseInt(cartProductQuantities.get(i).getAttribute("value"));
                return actualQuantity == expectedQuantity;
            }
        }
        return false;
    }

    public int getTotalItemsInCart() {
        String totalText = totalItemsLabel.getText().replaceAll("\\D+", "");
        return Integer.parseInt(totalText);
    }
}
