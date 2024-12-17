package rev.project.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(

        features =
                {
                        "src/test/resources/features/Registration.feature",
                        "src/test/resources/features/homepage.feature"
////                        "src/test/resources/features/searchFunctionality.feature",
//                        "src/test/resources/features/productDetailsPage.feature",
//                        "src/test/resources/features/addToCart.feature",
//                        "src/test/resources/features/brokenLink.feature",

                },

        glue = {"rev.project.stepDefinitions", "rev.project.hooks"},
//        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        // feature m ek aur runner bna ke use file ka address de dena hau  @target/file.txt
        plugin = {"pretty",
                "rerun:target/file.txt",
                "html:target/cucumber-reports/cucumber.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},

        monochrome = true
)
//@Listeners(rev.project.listners.ScreenshotListener.class)
public class HomePageRunner extends AbstractTestNGCucumberTests {
    // The test methods are automatically triggered by AbstractTestNGCucumberTests
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
