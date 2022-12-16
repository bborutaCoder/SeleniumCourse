package junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

public class Zadanie4Junit {

    private static WebDriver driver;

    @BeforeAll
    public static void classSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public static void classTearDown() { driver.quit();}

    @BeforeEach
    public void setUp() {
        driver.get("https://hotel-testlab.coderslab.pl//en/");
    }

    @Test
    public void createNewUserAccount() {
        // Arrange
        String firstName = "John";
        String lastName = "Doe";
        String password = "admin1";

        String email = generateEmail();

        // Act
        WebElement SingInElement = driver.findElement(By.className("hide_xs"));
        SingInElement.click();
        WebElement emailAdress = driver.findElement(By.id("email_create"));
        emailAdress.sendKeys(email);
        WebElement createAnAccont = driver.findElement(By.id("SubmitCreate"));
        createAnAccont.click();

        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        if (firstNameElement.isDisplayed()) {
            firstNameElement.sendKeys(firstName);
        } else {
            Assertions.fail("First name is not displayed");
        }
        WebElement lastNameElement = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        if (lastNameElement.isDisplayed()) {
            lastNameElement.sendKeys(lastName);
        } else {
            Assertions.fail("Last name is not displayed");
        }
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        if (emailElement.isDisplayed()) {
            emailElement.clear();
            emailElement.sendKeys(email);
        } else {
            Assertions.fail("E-mail is not displayed");
        }
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        if (passwordElement.isDisplayed()) {
            passwordElement.sendKeys(password);
        } else {
            Assertions.fail("Password is not displayed");
        }
        WebElement daySelectElement = driver.findElement(By.id("days"));
        Select daySelect = new Select(daySelectElement);
        daySelect.selectByValue("16");

        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }

        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();

        // Assert
        WebElement successAlert = driver.findElement(By.cssSelector("#center_column > p.alert.alert-success"));
        String successAlertText = successAlert.getText();
        Assertions.assertTrue(successAlertText.contains("Your account has been created."));

        WebElement userFirstNameElement = driver.findElement(By.cssSelector("#user_info_acc > span.account_user_name.hide_xs"));
        String userFirstNameText = userFirstNameElement.getText();
        Assertions.assertTrue(userFirstNameText.contains(firstName));
    }

    @Test
    public void cannotUseExistingEmailTest() {
        // Arrange
        String alreadyRegisteredEmail = "gfv76r@test.com";

        // Act
        WebElement SingInElement = driver.findElement(By.className("hide_xs"));
        SingInElement.click();
        WebElement emailAdress = driver.findElement(By.id("email_create"));
        emailAdress.sendKeys(alreadyRegisteredEmail);
        WebElement createAnAccont = driver.findElement(By.id("SubmitCreate"));
        createAnAccont.click();

        // Assert
        WebElement alreadyExistingValidation = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
        Assertions.assertTrue(alreadyExistingValidation.isDisplayed());

//        String alreadyExistingValidationText = alreadyExistingValidation.getText();
//        Assertions.assertTrue(alreadyExistingValidationText.contains("Istnieje już zarejestrowane konto z tym adresem e-mail, wprowadź proszę swoje hasło lub poproś o nowe."));
    }

    private String generateEmail() {
        String randomName = "user_";
        Random r = new Random();
        int number = r.nextInt(1000000);
        randomName += number;
        String domain = "@mailTest.com";

        return randomName + domain;
    }
}
