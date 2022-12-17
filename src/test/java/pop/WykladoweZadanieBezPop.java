package pop;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WykladoweZadanieBezPop {

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

        WebElement homepageSubmitButton = driver.findElement(
                By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        homepageSubmitButton.click();

        WebElement emailInput = driver.findElement(By.id("field-email"));
        emailInput.sendKeys(userEmail);
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys(userPassword);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();

        WebElement userNameField = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"));
        Assertions.assertEquals(userFullName, userNameField.getText());
    }

    @Test
    public void loginWithBadPasswordTest() {
        String userEmail = "johnd@mail.com";
        String badPassword = "admin1";
        String authenticationFailedText = "Authentication failed.";

        WebElement homepageSubmitButton = driver.findElement(
                By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        homepageSubmitButton.click();

        WebElement emailInput = driver.findElement(By.id("field-email"));
        emailInput.sendKeys(userEmail);
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys(badPassword);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();

        WebElement authenticationFaildAlert = driver.findElement(
                By.xpath("//*[@id=\"content\"]/section/div/ul/li"));
        Assertions.assertEquals(authenticationFailedText, authenticationFaildAlert.getText());
    }
}
