package popZadania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver =driver;
    }

    public void startRegistration(String email){
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys(email);
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
    }

    public void loginAs(String email, String password){
        WebElement emailAdressInput = driver.findElement(By.id("email"));
        emailAdressInput.sendKeys(email);
        WebElement passwordInputElement = driver.findElement(By.id("passwd"));
        passwordInputElement.sendKeys(password);
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        signInButton.click();
    }
}
