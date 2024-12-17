package rev.project.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rev.project.hooks.Hooks;
import rev.project.pages.ProductDetailsPage;

import static org.testng.AssertJUnit.assertTrue;

public class ProductDetailsPageStepDef {

    WebDriver driver;
    ProductDetailsPage productDetailsPage;

    public ProductDetailsPageStepDef(Hooks driverHooks) {
        driver = driverHooks.getDriver();
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Given("I navigate to the Amazon home page")
    public void navigateToProductDetailsPage() {
        productDetailsPage.navigateToHomePage(); // Navigate to Amazon home page
    }

    @When("I search for a product with the name {string}")
    public void searchForProduct(String productName) {
        productDetailsPage.searchForProduct(productName);
    }

    @When("I select the first product from the search results containing {string}")
    public void selectFirstProduct(String productName) {
        productDetailsPage.clickOnSearchResultContainingProductName(productName);
    }


    @Then("I should see the product name containing {string}")
    public void validateProductName(String expectedProductName) {
        // Get the dynamic product title based on the product name
        WebElement productTitle = productDetailsPage.getProductTitle(expectedProductName);

        String actualProductName = productTitle.getText();
        if (!actualProductName.contains(expectedProductName)) {
            throw new AssertionError("Expected product name to contain: " + expectedProductName
                    + ", but got: " + actualProductName);
        }
    }


    @Then("the price should be displayed")
    public void validateProductPrice() {
        assertTrue("Product price is not displayed", productDetailsPage.isPriceDisplayed());
    }

    @Then("the availability status should be displayed")
    public void validateProductAvailability() {
        assertTrue("Product availability status is not displayed", productDetailsPage.isAvailabilityDisplayed());
    }

    @Then("the product should have customer reviews")
    public void validateProductReviews() {
        assertTrue("Product reviews are not displayed", productDetailsPage.hasCustomerReviews());
    }
}
