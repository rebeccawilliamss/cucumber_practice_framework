// Training purposes only!!
// CHANGE PASSWORDS BEFORE TESTING OR TEST WILL NOT WORK
// TEST is a placeholder

package stepdefs.CreateAccount;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CreateAccountSteps {

    WebDriver driver;

    //private By signInButton = By.id("idcta-link");
    //private By registerNowLink = By.cssSelector("#signin-page > div.page__wrapper > div.page__grid-wrapper > div.page__content-wrapper > div.page__content.page__content--secondary > a > span");
    private By ageRestrictionButton = By.cssSelector("#container > div > div > div > div.page__wrapper > div.page__grid-wrapper > div.page__content-wrapper > div > div.form > fieldset > div.buttons__wrapper > a:nth-child(2)");
    private By dayField = By.id("day-input");
    private By monthField = By.id("month-input");
    private By yearField = By.id("year-input");
    private By continueButton = By.id("submit-button");
    private By emailField = By.id("user-identifier-input");
    private By passwordField = By.id("password-input");
    private By postCodeField = By.id("postcode-input");
    private By genderDropDownMenu = By.id("gender-input");
    private By registerButton = By.id("submit-button");
    private By emailVerificationMessage = By.id("form-message-info");
    private By errorMessage = By.id("form-message-email");


    @Given("I am on the create account page")
    public void i_am_on_the_create_account_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\R2Williams\\IdeaProjects\\CucumberPracticeBbcWebsite\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://account.bbc.com/register");
        driver.manage().window().maximize();
        driver.findElement(ageRestrictionButton).click();
    }

    @When("I fill out the required fields")
    public void i_fill_out_the_required_fields() {
        driver.findElement(dayField).clear();
        driver.findElement(dayField).sendKeys("19");

        driver.findElement(monthField).clear();
        driver.findElement(monthField).sendKeys("september");

        driver.findElement(yearField).clear();
        driver.findElement(yearField).sendKeys("1995");
        driver.findElement(continueButton).click();

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys("becca18xx@yahoo.co.uk");

        driver.findElement(passwordField).sendKeys("TEST");

        driver.findElement(postCodeField).clear();
        driver.findElement(postCodeField).sendKeys("TEST");

        Select gender = new Select(driver.findElement(genderDropDownMenu));
        gender.selectByValue("female");

        driver.findElement(registerButton).click();
    }

    @When("I fill out the email address field using an already registered email")
    public void i_fill_out_the_email_address_field_using_an_already_registered_email() {
        driver.findElement(dayField).clear();
        driver.findElement(dayField).sendKeys("19");

        driver.findElement(monthField).clear();
        driver.findElement(monthField).sendKeys("september");

        driver.findElement(yearField).clear();
        driver.findElement(yearField).sendKeys("1995");
        driver.findElement(continueButton).click();

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys("rebecca.williams18@yahoo.co.uk");

        driver.findElement(passwordField).sendKeys("TEST");

        driver.findElement(postCodeField).clear();
        driver.findElement(postCodeField).sendKeys("TEST");

        Select gender = new Select(driver.findElement(genderDropDownMenu));
        gender.selectByValue("female");

        driver.findElement(registerButton).click();
    }

    @Then("my account should be successfully created")
    public void my_account_should_be_successfully_created() {
        driver.findElement(emailVerificationMessage).isDisplayed();
        System.out.println("Test passed");
        driver.quit();
    }

    @Then("an error message should display")
    public void an_error_message_should_display() {
        assertEquals("Looks like you’ve already registered with this email. Want to sign in?", driver.findElement(errorMessage).getText());
        System.out.println(driver.findElement(errorMessage).getText());
        System.out.println("Test passed");
        driver.quit();
    }
}
