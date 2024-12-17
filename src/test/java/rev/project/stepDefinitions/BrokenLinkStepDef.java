package rev.project.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rev.project.hooks.Hooks;
import rev.project.pages.BrokenPage;
import rev.project.utils.BrokenLinkValidator;

import java.time.Duration;
import java.util.List;

public class BrokenLinkStepDef {
    WebDriver driver;
    BrokenPage brokenPage;

    public BrokenLinkStepDef(Hooks hooks) {
        driver = hooks.getDriver();
        brokenPage = new BrokenPage(driver);
    }

    @Given("I am on the Amazon homepage")
    public void iAmOnTheAmazonHomepage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/Samsung-Storage-MediaTek-Dimensity-Security/d11p/B0DGX92NBH/?_encoding=UTF8&pd_rd_w=1WTmI&content-id=amzn1.sym.509965a2-791b-4055-b876-943397d37ed3%3Aamzn1.symc.fc11ad14-99c1-406b-aa77-051d0ba1aade&pf_rd_p=509965a2-791b-4055-b876-943397d37ed3&pf_rd_r=WEADYV1KDPDAKW0ZHWMK&pd_rd_wg=A4VYs&pd_rd_r=f6e725c6-c2c6-44b3-8c61-b3b71e453458&ref_=pd_hp_d_atf_ci_mcx_mr_ca_hp_atf_d");
        brokenPage.waitForPageLoad();
    }

    @When("I extract all the links from the page")
    public void iExtractAllTheLinksFromThePage() {
        List<WebElement> links = brokenPage.getAllLinks();
        System.out.println("Number of links found: " + links.size());
        BrokenLinkValidator.validateLinks(links);
    }

    @Then("I should see that all links are valid")
    public void iShouldSeeThatAllLinksAreValid() {
        System.out.println("Broken link validation completed.");
    }
}
