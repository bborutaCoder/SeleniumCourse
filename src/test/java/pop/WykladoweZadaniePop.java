package pop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pop.pages.HeaderElement;
import pop.pages.LoginPage;

import java.time.Duration;

public class WykladoweZadaniePop {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginWithProperCredentialsTest() {
        String userEmail = "johnd@mail.com";
        String userPassword = "qwerty";
        String userFullName = "John Doe";

        HeaderElement headerElement = new HeaderElement(driver);
        headerElement.goToSignInPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(userEmail, userPassword);

        Assertions.assertEquals(userFullName, headerElement.getUserFullName());
    }

    @Test
    public void loginWithBadPasswordTest() {
        String userEmail = "johnd@mail.com";
        String badPassword = "admin1";
        String authenticationFailedText = "Authentication failed.";

        HeaderElement headerElement = new HeaderElement(driver);
        headerElement.goToSignInPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(userEmail, badPassword);

        Assertions.assertEquals(authenticationFailedText, loginPage.getAuthenticationFailedAlertText());
    }
}
