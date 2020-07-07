package stepdefs.LocalPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LocalSteps {

    private WebDriver driver;

    private By moreDropDownButton = By.cssSelector("#orb-nav-more > a");
    private By localLink = By.cssSelector("#orb-panel-more > div > ul > li.orb-nav-local > a");
    private By searchBar = By.id("ls-c-search__input-label");
    private By dropDownSelection = By.cssSelector("#location-list > li:nth-child(1) > a");

//    @Before
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\R2Williams\\IdeaProjects\\CucumberPracticeBbcWebsite\\src\\main\\resources\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("https://www.bbc.co.uk/news");
//        driver.manage().window().maximize();
//    }

    @Given("I am on the local news page")
    public void i_am_on_the_local_news_page() {
        driver.findElement(moreDropDownButton).click();
        driver.findElement(localLink).click();
    }

    @When("I type Andover into the search bar")
    public void i_type_Andover_into_the_search_bar() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals("Url does not match", url.equals(url));
        driver.findElement(searchBar).sendKeys("Andover");
        driver.findElement(searchBar).submit();
        driver.findElement(dropDownSelection).click();
    }

    @Then("I should be taken to the local news page for Andover")
    public void i_should_be_taken_to_the_local_news_page_for_Andover() {
       String url = driver.getCurrentUrl();
       Assert.assertEquals("Url does not match", url.equals(url));
       System.out.println("Test passed");
    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}
