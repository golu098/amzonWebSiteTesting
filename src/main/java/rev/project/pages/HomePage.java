package rev.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rev.project.utils.ConfigUtils;

public class HomePage extends BasePage{
    WebDriver driver;

    @FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
    private WebElement searchBarLocator;

    @FindBy(xpath = "//span[@class=\"nav-cart-icon nav-sprite\"]")
    private  WebElement cartIconLocator;

    @FindBy(xpath="//span[@id=\"nav-link-accountList-nav-line-1\"]")
    private  WebElement loginButton;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void userNavigateToHomePage() {
        String url= ConfigUtils.accessUrl("homepage.url");
        driver.get(url);
    }

//    public void itemCheckOnHomePage(String item) {
//        switch (item){
//            case "search bar ":
//                searchBarLocator.click();
//                break;
//            case "cart icon ":
//                cartIconLocator.click();
//                break;
//            case "Login Button":
//                loginButton.click();
//                break;
//            default:
//                System.out.println(item + " is not available on HomePage ");
//        }
//    }
// Method to check if an item is present on the page
public boolean isItemPresent(String item) {
    switch (item.trim().toLowerCase()) {
        case "search bar":
            return isElementDisplayed(searchBarLocator);
        case "cart icon":
            return isElementDisplayed(cartIconLocator);
        case "login button":
            return isElementDisplayed(loginButton);
        default:
            return false;
    }
}

    // Utility method to check if an element is displayed
    private boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // Element not found or not displayed
        }
    }

}
