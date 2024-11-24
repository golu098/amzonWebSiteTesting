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

    @Then("I should see search results containing the keyword {string}")
    public void iShouldSeeSearchResultsContainingTheKeyword(String keyword) {

        boolean resultsValid = searchFunctionalityPage.areResultsContainingKeyword(keyword);
        assertTrue("Not all search results contain the keyword: " + keyword, resultsValid);
    }

    @Then("the total number of results should be displayed")
    public void theTotalNumberOfResultsShouldBeDisplayed() {
        String resultsCount = searchFunctionalityPage.getResultsCountText();
        assertFalse("Total results count is not displayed!", resultsCount.isEmpty());
        System.out.println("Total number of results: " + resultsCount);
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

    @Then("only products from the brand {string} should be displayed")
    public void onlyProductsFromTheBrandShouldBeDisplayed(String brand) {
        boolean isFiltered = searchFunctionalityPage.verifyFilterResults(brand);
        assertTrue("Not all results are from the brand: " + brand, isFiltered);
    }
}
