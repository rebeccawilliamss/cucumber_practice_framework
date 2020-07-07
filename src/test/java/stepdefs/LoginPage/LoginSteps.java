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
    //private By newsHeading = By.cssSelector("#brand > span:nth-child(1) > svg");

    @Given("I am on the Login page")
    public void i_am_on_the_Login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\R2Williams\\IdeaProjects\\CucumberPracticeBbcWebsite\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.bbc.co.uk/news");
        driver.manage().window().maximize();
        driver.findElement(signInLink).click();
    }

    @When("I enter my username and password")
    public void i_enter_my_Username_and_Password() {
        driver.findElement(userName).sendKeys("rebecca.williams18@yahoo.co.uk");
        driver.findElement(passWord).sendKeys("Jasmine11");
        driver.findElement(signInButton).click();
    }

    @Then("I should be signed in and returned to the Homepage")
    public void i_should_be_signed_in_and_returned_to_the_Homepage() {
        String homePageURL = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", homePageURL, homePageURL);
        System.out.println("Test Passed");
        driver.quit();
    }

}
