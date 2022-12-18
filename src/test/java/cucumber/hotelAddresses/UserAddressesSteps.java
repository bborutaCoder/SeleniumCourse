package cucumber.hotelAddresses;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
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

    @Then("new address data is correct and contains {string}, {string}, {string}, {string}, {string}, {string}")
    public void newAddressDataIsCorrectAndContains(String street, String postalCode, String city, String country, String phone, String title) {

        // pobieranie danych albo sprawdzanie ich powinno byc w page object
        String aliasText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[1]/h3")).getText();
        Assertions.assertEquals(title.toUpperCase(), aliasText);

        String streetText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span")).getText();
        Assertions.assertEquals(street, streetText);

        String postalCodeText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[7]/span[1]")).getText().trim();
        Assertions.assertEquals(postalCode, postalCodeText);

        String cityText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[7]/span[2]")).getText();
        Assertions.assertEquals(city, cityText);

        String countryText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[8]/span")).getText();
        Assertions.assertEquals(country, countryText);

        String phoneNumberText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/span")).getText();
        Assertions.assertEquals(phone, phoneNumberText);
    }

    @And("delete address")
    public void deleteAddress() {
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[11]/a[2]")).click();
        driver.switchTo().alert().accept();
    }
}
