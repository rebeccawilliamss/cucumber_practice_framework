package stepdefs.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver;

    private By signInLink = By.id("idcta-username");
    private By userName = By.id("user-identifier-input");
    private By passWord = By.id("password-input");
    private By signInButton = By.id("submit-button");
    private By signOutButton = By.cssSelector("#container > div > div > div.background.background--attenborough > div.u-background-transparent-black > div > div > div > div > nav > ul > li:nth-child(4) > a");
    private By settingsLink = By.cssSelector("#container > div > div > div.background.background--attenborough > div.u-background-transparent-black > div > div > div > div > nav > ul > li:nth-child(2) > a");
    private By deleteAccountLink = By.cssSelector("#app-container > div > div > div.u-margin-left.profile__overview > div.u-display-flex--tablet > div.profile__content-container.gel-layout__item.gel-1_1.gel-8_12--tablet.gel-9_12--desktop.u-padding-left-none > div > div.profile__content-limiter--wide > div > p > a");
    private By enterPassword = By.id("password-input");
    private By deleteAccountButton = By.cssSelector("#app-container > div > div > div.u-margin-left > div.u-display-flex--tablet > div.profile__content-container.gel-layout__item.gel-1_1.gel-8_12--tablet.gel-9_12--desktop.u-padding-left-none > div > div.profile__content-limiter > form > div.buttons > button");


    @Given("I am on the Login page")
    public void i_am_on_the_Login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\R2Williams\\IdeaProjects\\CucumberPracticeBbcWebsite\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.bbc.co.uk/news");
        driver.manage().window().maximize();
        driver.findElement(signInLink).click();
    }

    @Given("I am logged into my BBC website account")
    public void i_am_logged_into_my_BBC_website_account() {
        driver.get("https://account.bbc.com/account");
        driver.manage().window().maximize();
        driver.findElement(userName).sendKeys("becca18xx@yahoo.co.uk");
        driver.findElement(passWord).sendKeys("Test123!?");
        driver.findElement(signInButton).click();
        String accountUrl = driver.getCurrentUrl();
        Assert.assertEquals("Url does not match", accountUrl, accountUrl);
    }

    @When("I enter my {string} and {string}")
    public void i_enter_my_Username_and_Password(String username, String password) {
        driver.findElement(userName).sendKeys(username);
        driver.findElement(passWord).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        driver.findElement(signOutButton).click();
    }

    @When("I select to delete my account")
    public void i_select_to_delete_my_account() {
        driver.findElement(settingsLink).click();
        driver.findElement(deleteAccountLink).click();
        driver.findElement(enterPassword).sendKeys("Test123!?");
        driver.findElement(deleteAccountButton).click();
    }

    @Then("I should be signed in and returned to the Homepage")
    public void i_should_be_signed_in_and_returned_to_the_Homepage() {
        String homePageURL = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", homePageURL, homePageURL);
        System.out.println("Test Passed");
        driver.quit();
    }

    @Then("I should be successfully logged out of my account")
    public void i_should_be_successfully_logged_out_of_my_account() {
        String signOutUrl = driver.getCurrentUrl();
        Assert.assertEquals("Url does not match", signOutUrl, signOutUrl);
        driver.quit();
    }

    @Then("my account should be successfully deleted")
    public void my_account_should_be_successfully_deleted() {
        String deletedAccountUrl = driver.getCurrentUrl();
        Assert.assertEquals("Url does not match", deletedAccountUrl, deletedAccountUrl);
        driver.quit();
    }




}
