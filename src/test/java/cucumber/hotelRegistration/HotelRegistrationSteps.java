package cucumber.hotelRegistration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import popZadania.pages.AuthenticationPage;
import popZadania.pages.CreateAnAccountPage;

import java.time.Duration;
import java.util.Random;

public class HotelRegistrationSteps {

    WebDriver driver;

    @Given("User is on main site and sign in clicked")
    public void userIsOnMainSiteAndSignInClicked() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl");
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span"));
        signInButton.click();
    }

    @When("User inputs email address and create an account button is clicked")
    public void userInputsEmailAddressAndCreateAnAccountButtonIsClicked() {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.startRegistration(generateEmail());
    }

    @When("User fills in the registration form and register button is clicked")
    public void userFillsInTheRegistrationFormAndRegisterButtonIsClicked() {
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.registerUser("Mariusz","Pudzianowski","qwerty");
    }

    @Then("User sees my account page")
    public void userSeesMyAccountPage() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://hotel-testlab.coderslab.pl/pl/moje-konto")
                || driver.getCurrentUrl().contains("https://hotel-testlab.coderslab.pl/en/my-account"));
    }

    @And("User sees his or her user name")
    public void userSeesHisHerUserName() {
        String userName = driver.findElement(By.xpath("//*[@id=\"user_info_acc\"]/span[1]")).getText();
        Assertions.assertEquals("Mariusz", userName);
    }


    public String generateEmail() {
        Random random = new Random();

        String[] names = {"user", "jdoe", "jasFasola", "superman"};
        String name = names[random.nextInt(names.length)];

        String[] domains = {"mail.com", "gmail.com", "o2.pl", "wp.pl"};
        String domain = domains[random.nextInt(domains.length)];

        int randomNumber = random.nextInt(1000000);
        return name + "_" + randomNumber + "@" + domain;
    }
}