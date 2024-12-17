package rev.project.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import rev.project.hooks.Hooks;
import rev.project.pages.AddToCartPage;

import java.util.List;
import java.util.Map;

public class AddtoCartStepDef {
    WebDriver driver; // Assumes the driver is set up in hooks
    AddToCartPage addToCartPage;

    public AddtoCartStepDef(Hooks driverHooks) {
        driver = driverHooks.getDriver();
        addToCartPage = new AddToCartPage(driver);
    }

    @Given("I add the following products to the cart:")
    public void iAddTheFollowingProductsToTheCart(DataTable table) {
        List<Map<String, String>> products = table.asMaps(String.class, String.class);
        for (Map<String, String> product : products) {
            String productName = product.get("Product Name");
            int quantity = Integer.parseInt(product.get("Quantity"));

            // Search for the product and add it to the cart
            addToCartPage.searchForProduct(productName);
            addToCartPage.selectProductFromResults(productName);
            for (int i = 0; i < quantity; i++) {
                addToCartPage.addToCart();
            }
        }
    }

    @Then("I should see a confirmation message {string} for each product")
    public void iShouldSeeAConfirmationMessageForEachProduct(String expectedMessage) {
        Assert.assertTrue(addToCartPage.isConfirmationMessageDisplayed(expectedMessage),
                "Expected confirmation message not displayed: " + expectedMessage);
    }

    @When("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        addToCartPage.goToCartPage();
    }

    @Then("I should see all the added products in the cart:")
    public void iShouldSeeAllTheAddedProductsInTheCart(DataTable table) {
        List<Map<String, String>> expectedProducts = table.asMaps(String.class, String.class);
        for (Map<String, String> expectedProduct : expectedProducts) {
            String productName = expectedProduct.get("Product Name");
            int expectedQuantity = Integer.parseInt(expectedProduct.get("Quantity"));
            Assert.assertTrue(addToCartPage.isProductInCart(productName, expectedQuantity),
                    "Product not found in cart or quantity mismatch: " + productName);
        }
    }

    @And("the total number of items in the cart should be {int}")
    public void theTotalNumberOfItemsInTheCartShouldBe(int expectedTotal) {
        int actualTotal = addToCartPage.getTotalItemsInCart();
        Assert.assertEquals(actualTotal, expectedTotal, "Cart total item count mismatch.");
    }
}
