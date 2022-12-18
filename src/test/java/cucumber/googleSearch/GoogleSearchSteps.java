package cucumber.googleSearch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchSteps {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void anOpenBrowserWithGoogleCom() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
    }

    @When("a keyword {} is entered in input field")
    public void aKeywordSeleniumIsEnteredInInputField(String keyword) {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(keyword);
        searchField.submit();
    }

    @Then("the first result should contain {}")
    public void theFirstResultShouldContainSelenium(String keyword) {
        System.out.println(keyword);
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
