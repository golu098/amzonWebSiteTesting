package rev.project.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"rev.project.stepDefinitions", "rev.project.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)
public class HomePageRunner extends AbstractTestNGCucumberTests {
    // The test methods are automatically triggered by AbstractTestNGCucumberTests
}
