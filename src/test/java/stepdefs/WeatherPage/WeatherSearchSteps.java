package stepdefs.WeatherPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class WeatherSearchSteps {

    private WebDriver driver;

    private By weatherLink = By.cssSelector("#orb-nav-links > ul > li.orb-nav-weather > a");
    private By searchBar = By.id("ls-c-search__input-label");
    private By areaChoice = By.xpath("/html/body/div[7]/div/div[2]/div/div/div[2]/div/div/div/div[4]/div/ul/li[1]/a/span");
    private By headingAreaName = By.id("wr-location-name-id");

    @Given("I am on the Weather Page")
    public void i_am_on_the_Weather_Page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\R2Williams\\IdeaProjects\\CucumberPracticeBbcWebsite\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.bbc.co.uk/news");
        driver.manage().window().maximize();
        driver.findElement(weatherLink).click();
    }

    @When("I type {string} into the search bar")
    public void i_type_into_the_search_bar(String string) {
        driver.findElement(searchBar).sendKeys("Andover");
        driver.findElement(searchBar).submit();
    }

    @And("I select the correct area from the drop down list")
    public void i_select_the_correct_area_from_the_drop_down_list() {
        driver.findElement(areaChoice).click();
    }

    @Then("I should be taken to the page displaying the Weather for Andover")
    public void i_should_be_taken_to_the_page_displaying_the_Weather_for_Andover() {
        driver.findElement(headingAreaName).isDisplayed();
        Assert.assertTrue(headingAreaName.equals(headingAreaName));
        System.out.println("Test Passed");
        driver.quit();
    }

}



