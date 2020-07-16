// Training purposes only!!
// CHANGE PASSWORDS BEFORE TESTING OR TEST WILL NOT WORK
// TEST is a placeholder

package stepdefs.EditAccount;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editAccountSteps {

    WebDriver driver;

    private By signInLink = By.id("idcta-username");
    private By username = By.id("user-identifier-input");
    private By password = By.id("password-input");
    private By signInButton = By.id("submit-button");
    private By accountButton = By.id("idcta-link");
    private By accountSettingsLink = By.cssSelector(".primary-nav__items li:nth-child(2)");

    private By nameEditButton = By.xpath("//*[@id=\"Display name-field\"]/div[2]");
    private By nameField = By.id("displayName-input");

    private By saveAndContinueButton = By.cssSelector("#app-container .button[type='submit']");
    private By successfulChangeMessage = By.cssSelector(".form-message");

    private By passwordEditButton = By.xpath("//*[@id='Password-field']/div[2]");
    private By currentPasswordField = By.id("current-password-input");
    private By newPasswordField = By.id("new-password-input");

    private By genderEditButton = By.xpath("//*[@id='Gender-field']/div[2]");
    private By genderInput = By.id("gender-input");

    @Given("I am on the BBC homepage")
    public void i_am_on_the_BBC_homepage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\R2Williams\\IdeaProjects\\CucumberPracticeBbcWebsite\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bbc.co.uk/news");
        driver.manage().window().maximize();
    }

    @Given("I am on my account page")
    public void i_am_on_my_account_page() {
        String accountSettingsUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", accountSettingsUrl, accountSettingsUrl);
    }

    @When("I sign into my account using my username and password")
    public void i_sign_into_my_account_using_my_username_and_password() {
        driver.findElement(signInLink).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("TEST");

        driver.findElement(password).sendKeys("TEST");
        driver.findElement(signInButton).click();
    }

    @When("I edit my display name in the Name field")
    public void i_edit_my_display_name_in_the_Name_field() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameEditButton)).click();

        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys("Rebecca");
        driver.findElement(saveAndContinueButton).submit();
    }

    @When("I edit my password in the Password field")
    public void i_edit_my_password_in_the_Password_field() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordEditButton)).click();

        driver.findElement(currentPasswordField).sendKeys("TEST");
        driver.findElement(newPasswordField).sendKeys("TEST");
        driver.findElement(saveAndContinueButton).submit();
    }

    @When("I edit my gender in the gender drop down menu")
    public void i_edit_my_gender_in_the_gender_drop_down_menu() {
        WebDriverWait wait1 = new WebDriverWait(driver, 3);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(genderEditButton)).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderInput));

        Select drpGender = new Select(driver.findElement(genderInput));
        drpGender.selectByValue("female");
        driver.findElement(saveAndContinueButton).submit();
    }

    @Then("I should be successfully signed into my account")
    public void i_should_be_successfully_signed_into_my_account() {
        String homePageURL = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", homePageURL, homePageURL);
    }

    @Then("I should be able to view my account information")
    public void i_should_be_able_to_view_my_account_information() {
        driver.findElement(accountButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountSettingsLink)).click();

        String accountSettingsUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", accountSettingsUrl, accountSettingsUrl);
    }

    @Then("my display name should be updated")
    public void my_display_name_should_be_updated() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulChangeMessage)).isDisplayed();

        System.out.println("Test passed");
        driver.quit();
    }

    @Then("my password should be updated")
    public void my_password_should_be_updated() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulChangeMessage)).isDisplayed();

        System.out.println("Test passed");
        driver.quit();
    }

    @Then("my gender should be updated")
    public void my_gender_should_be_updated() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulChangeMessage)).isDisplayed();

        System.out.println("Test passed");
        driver.quit();
    }
}