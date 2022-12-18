package cucumber.hotelAddresses;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import popZadania.pages.AddNewAddressPage;
import popZadania.pages.AuthenticationPage;

import java.time.Duration;

public class UserAddressesSteps {

    private WebDriver driver;

    @Given("registered user on the {string} page")
    public void registeredUserOnThePage(String websiteUrl) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(websiteUrl);
    }

    @And("user is logged in with email {string} and password {string}")
    public void userIsLoggedInWithEmailAndPassword(String email, String password) {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginAs(email, password);
    }

    @When("user click Add a New Address button")
    public void userClickAddMyFirstAddressButton() {
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/a")).click();
    }

    @When("user fills in new address form with {string}, {string}, {string}, {string}, {string}, {string} user clicks Save button")
    public void userFillsInNewAddressFormWith(String street, String postalCode, String city, String country, String phone, String title) {
        AddNewAddressPage addNewAddressPage = new AddNewAddressPage(driver);
        addNewAddressPage.createNewAddress(street, postalCode, city, country, phone, title);
    }
}
