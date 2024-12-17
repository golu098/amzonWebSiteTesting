package rev.project.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import rev.project.hooks.Hooks;
import rev.project.pages.RegistartionPage;
import rev.project.utils.WaitUtils;

import java.util.List;
import java.util.Map;

public class RegistartionStepDef {
    WebDriver driver;
    RegistartionPage registartionPage;

    public RegistartionStepDef(Hooks driverHooks) {
        driver = driverHooks.getDriver();
        registartionPage = new RegistartionPage(driver);
    }

    @Given("the user is on the registration page")
    public void setRegistartionPage() {
        registartionPage.loadPage();
        WaitUtils.waitForVisibilityOfElement(driver, registartionPage.getFormLocator());
    }

    @When("the page loads")
    public void thePageLoads() {
        Assert.assertTrue(WaitUtils.waitForVisibilityOfElement(driver, registartionPage.getFormLocator()).isDisplayed(),
                "Registration form is not displayed");
    }

    @Then("a registration form should be prominently displayed with the required fields:")
    public void aRegistrationFormShouldBeProminentlyDisplayedWithTheRequiredFields(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String field = row.get("Field");
            String type = row.get("Type");
            String validation = row.get("Validation");

            WebElement fieldElement = registartionPage.getFieldElement(field);
            WaitUtils.waitForVisibilityOfElement(driver, fieldElement);
            System.out.println("Field: " + field + ", Type: " + type + ", Validation: " + validation);
        }
    }

    @Given("a user enters valid details in the registration form:")
    public void aUserEntersValidDetailsInTheRegistrationForm(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            registartionPage.enterName(row.get("Your name"));
            registartionPage.enterMobile(row.get("Mobile number"));
            registartionPage.enterPassword(row.get("password"));
        }
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String buttonName) {
        WaitUtils.waitForElementToBeClickable(driver, registartionPage.getSubmitButton());
        registartionPage.clickSubmit();
    }

//    @Then("an error message should dynamically appear next to the {string} field, specifying the error {string}")
//    public void anErrorMessageShouldDynamicallyAppearNextToTheFieldSpecifyingTheError(String fieldName, String expectedError) {
//        String actualError = switch (fieldName.toLowerCase()) {
//            case "your name" -> registartionPage.getNameError();
//            case "mobile number" -> registartionPage.getMobileError();
//            case "password" -> registartionPage.getPasswordError();
//            default -> throw new IllegalArgumentException("Invalid field name: " + fieldName);
//        };
//        Assert.assertEquals(actualError, expectedError, "Error message mismatch for field: " + fieldName);
//    }

    @Given("a user enters a password {string} shorter than {int} characters")
    public void aUserEntersAPasswordShorterThanCharacters(String password, int length) {
        registartionPage.enterPassword(password);
    }

    @When("the user submits the form")
    public void theUserSubmitsTheForm() {
        registartionPage.clickSubmit();
    }

    @Then("the form should show an error message {string}")
    public void theFormShouldShowAnErrorMessage(String expectedErrorMessage) {
        String errorMessage = registartionPage.getPasswordErrorMessage().getText();
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }

    @Given("a user has visited and then moved away from the {string} field")
    public void aUserHasVisitedAndThenMovedAwayFromTheField(String fieldName) {
        WebElement field = registartionPage.getFieldByName(fieldName);
        WaitUtils.waitForVisibilityOfElement(driver, field);

        // Simulate visiting and moving away (focus and blur)
        field.click();
        field.sendKeys(""); // Leave the field empty
        Actions actions = new Actions(driver);
        actions.sendKeys("\n").perform();
    }

    @When("the input in the {string} field is invalid or missing after the visit")
    public void theInputInTheFieldIsInvalidOrMissingAfterTheVisit(String fieldName) {
        WebElement field = registartionPage.getFieldByName(fieldName);
        WaitUtils.waitForVisibilityOfElement(driver, field);

        field.clear(); // Clear the field to make input invalid
        field.sendKeys(""); // Simulate invalid input if needed
//        field.sendKeys(En); // Trigger validation by moving away
        Actions actions = new Actions(driver);
        actions.sendKeys("\n").perform();
    }

    @Then("an error message should dynamically appear next to the {string} field, specifying the error {string}")
    public void anErrorMessageShouldDynamicallyAppearNextToTheFieldSpecifyingTheError(String fieldName, String expectedError) {
        String actualError = registartionPage.getErrorForField(fieldName);
        Assert.assertEquals(actualError, expectedError, "Error message mismatch for field: " + fieldName);
    }

//    @Given("a user enters a phone number that is not {int} digits")
//    public void aUserEntersAPhoneNumberThatIsNotDigits(int digits) {
//
//        String invalidPhoneNumber = "12345";
//
//        // Validate the phone number length
//        if (invalidPhoneNumber.length() != digits) {
//            System.out.println("Invalid phone number entered: " + invalidPhoneNumber);
//        } else {
//            throw new RuntimeException("Phone number unexpectedly matches the required length.");
//        }
//    }
}
