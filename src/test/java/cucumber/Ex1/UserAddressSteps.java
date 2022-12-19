package cucumber.Ex1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pop.pages.CreateNewAddress;

import java.time.Duration;

public class UserAddressSteps {

    WebDriver driver;

    @Given("user logins to previously created account with details {string}, {string}")
    public void userLoginsToPreviouslyCreatedAccount(String email, String password) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");

        WebElement emailInput = driver.findElement(By.id("field-email"));
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @When("user goes to addresses - URL")
    public void userClicksOnAddressesURL() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
    }

    @And("clicks on new address")
    public void clicksOnNewAddress() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span")).click();
    }

    @Then("user fills New address with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillsNewAddressWith(String alias, String address, String city, String zip, String country, String phone) {
        CreateNewAddress createNewAddress = new CreateNewAddress(driver);
        createNewAddress.saveNewAddress(alias, address, city, zip, country, phone);
    }

    @And("checks if data in New address contains proper details {string}, {string}, {string}, {string}, {string}, {string}")
    public void checksIfDataInNewAddressAreCorrect(String alias, String address, String city, String zip, String country, String phone) {

        String aliasText = driver.findElement(By.xpath("//section/div[2]/article/div[1]/h4")).getText();
        Assertions.assertEquals(alias, aliasText);

        String addressText = driver.findElement(By.xpath("//section/div[2]/article/div[1]/address")).getText();
        Assertions.assertTrue(addressText.contains(address) && addressText.contains(city) &&  addressText.contains(zip) &&
                addressText.contains(country) && addressText.contains(phone));
    }
}
