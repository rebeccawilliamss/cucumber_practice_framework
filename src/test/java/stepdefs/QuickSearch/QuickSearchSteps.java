package stepdefs.QuickSearch;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class QuickSearchSteps {

    WebDriver driver;

    private By quickSearchBar = By.id("orb-search-q");

    @Given("that I am on the BBC Homepage")
    public void that_I_am_on_the_BBC_Homepage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\R2Williams\\IdeaProjects\\CucumberPracticeBbcWebsite\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://account.bbc.com/register");
        driver.manage().window().maximize();
        String homePageURL = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match Homepage", homePageURL.equals(homePageURL));
    }

    @When("I type {string} into the search box")
    public void i_type_into_the_search_box() {
        driver.findElement(quickSearchBar).sendKeys("coronavirus");
    }

    @And("I click on the search icon")
    public void i_click_on_the_search_icon() {
        driver.findElement(quickSearchBar).submit();
    }

    @Then("I am taken to that result page")
    public void i_am_taken_to_that_result_page() {
        String resultsPageURL = driver.getCurrentUrl();
        Assert.assertEquals("Url does not match the results page", resultsPageURL.equals(resultsPageURL));
        driver.quit();
    }

}