package rev.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rev.project.utils.ConfigUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchFunctionalityPage extends BasePage{
    WebDriver driver;

    @FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
    private WebElement searchBar;

    @FindBy(id = "nav-search-submit-button") // Search button
    private WebElement searchButton;
    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")// Search result titles
    private WebElement searchResults;
    @FindAll(@FindBy(xpath = "//button[@class=\"a-button-text\"]")) // Results count
    private List<WebElement> resultsCount;

    @FindBy(xpath = "//span[@class='a-dropdown-label']") // Sorting dropdown
    private WebElement sortDropdown;

    @FindBy(xpath = "//li[@aria-label='Price: Low to High']") // Sorting option
    private WebElement lowToHighOption;

    @FindAll(@FindBy(css = ".a-price-whole")) // Prices of products
    private List<WebElement> productPrices;

    @FindBy(xpath = "//span[contains(text(),'HP') and @class='a-size-base']") // Brand filter
    private WebElement brandFilter;

    public SearchFunctionalityPage(WebDriver driver) {
        super(driver); // Call the parent constructor
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void homePage() {
        String url= ConfigUtils.accessUrl("homepage.url");
        driver.get(url);
    }

    public void searchProduct(String productName) {
        type(searchBar, productName);
        click(searchButton);
    }

    public boolean isKeywordAtTop(String keyword) {
        waitForVisibility(searchResults);
        return searchResults.getText().trim().toLowerCase().contains(keyword.toLowerCase());
    }

    public int getResultsCountText() {
        waitForVisibility(resultsCount.get(0));
        return resultsCount.size();
    }

    public void applySortingOption(String sortOption) {
        click(sortDropdown);
        if (sortOption.equalsIgnoreCase("Price: Low to High")) {
            click(lowToHighOption);
        }
    }

    public boolean verifyPriceSorting() {
        List<Integer> prices = productPrices.stream()
                .map(price -> Integer.parseInt(price.getText().replace(",", "")))
                .collect(Collectors.toList());
        return IntStream.range(0, prices.size() - 1).allMatch(i -> prices.get(i) <= prices.get(i + 1));
    }

    public void applyFilter(String filter) {
        if (filter.equalsIgnoreCase("Brand: HP")) {
            click(brandFilter);
        }
    }



//    public boolean verifyFilterResults(String brand) {
//        return searchResults.stream()
//                .allMatch(result -> result.getText().toLowerCase().contains(brand.toLowerCase()));
//    }

}
