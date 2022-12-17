package popZadania;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import popZadania.pages.AuthenticationPage;
import popZadania.pages.CreateAnAccountPage;
import snippets.RandomEmailMain;

import java.time.Duration;
import java.util.Random;

public class TestRegistration {
    @Test
    public void registerUserTest() {

        Random random = new Random();
        int randomNumber = random.nextInt(1000000);
        String email = "user_" + randomNumber + "@mail.com";

        String firstName = "John";
        String lastName = "Doe";
        String password = "passwordhehehe";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        WebElement signInButton =  driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a"));
        signInButton.click();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.startRegistration(email);

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.registerUser(firstName, lastName, password);
    }
}
