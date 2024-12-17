package rev.project.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import rev.project.hooks.Hooks;
import rev.project.pages.HomePage;

import java.util.List;

public class HomePageStepDef {

    HomePage homePage;
    WebDriver driver;

    public HomePageStepDef(Hooks driverHook){
       this.driver=driverHook.getDriver();
       homePage=new HomePage(driver);
    }
    @Given("User is on the HomePage")
    public void userHomePage(){
        homePage.userNavigateToHomePage();
    }

    @When("Check below items are present on the Website")
    public void itemCheckOnHomePage(DataTable dataTable) {
        List<String> allItems = dataTable.asList();
        for (String item : allItems) {
            boolean isPresent = homePage.isItemPresent(item);
            if (!isPresent) {
                System.out.println(item + " is not available on HomePage.");
            } else {
                System.out.println(item + " is available on HomePage.");
            }
        }
//        Assert.assertTrue(false, "String message");
    }
}
