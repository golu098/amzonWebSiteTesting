package rev.project.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import rev.project.hooks.Hooks;
import rev.project.pages.SearchFunctionalityPage;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SearchFunctionalitySetpDef {

    WebDriver driver;
    SearchFunctionalityPage searchFunctionalityPage;

    public SearchFunctionalitySetpDef(Hooks driverHooks) {
        driver = driverHooks.getDriver();
        searchFunctionalityPage = new SearchFunctionalityPage(driver);
    }

    @Given("I am on the Amazon home page")
    public void userIsHomepage() {
        searchFunctionalityPage.homePage();
    }

    @When("I search for a product {string}")
    public void iSearchForAProduct(String productName) {
        searchFunctionalityPage.searchProduct(productName);
    }

    @Then("The keyword {string} should be at the top of the search results")
    public void theKeywordShouldBeAtTheTopOfTheSearchResults(String keyword) {
        boolean isAtTop = searchFunctionalityPage.isKeywordAtTop(keyword);
        assertTrue("The keyword '" + keyword + "' is not displayed at the top of the search results!", isAtTop);
    }


    @Then("the total number of results should be displayed")
    public void theTotalNumberOfResultsShouldBeDisplayed() {
        int resultsCount = searchFunctionalityPage.getResultsCountText();
        System.out.println("Total items displayed: " + resultsCount);

    }

    @When("I apply the sorting option {string}")
    public void iApplyTheSortingOption(String sortOption) {
        searchFunctionalityPage.applySortingOption(sortOption);
    }

    @Then("the products should be displayed in ascending order of price")
    public void theProductsShouldBeDisplayedInAscendingOrderOfPrice() {
        boolean isSorted = searchFunctionalityPage.verifyPriceSorting();
        assertTrue("Products are not sorted in ascending order of price", isSorted);
    }

    @When("I apply the filter for {string}")
    public void iApplyTheFilterFor(String filter) {
        searchFunctionalityPage.applyFilter(filter);
    }

//    @Then("only products from the brand {string} should be displayed")
//    public void onlyProductsFromTheBrandShouldBeDisplayed(String brand) {
//        boolean isFiltered = searchFunctionalityPage.verifyFilterResults(brand);
//        assertTrue("Not all results are from the brand: " + brand, isFiltered);
//    }
}
