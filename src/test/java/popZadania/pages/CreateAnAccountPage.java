package popZadania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAnAccountPage {
    private WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void registerUser(String firstName, String lastName, String password){
        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput =  driver.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys(lastName);
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys(password);

        WebElement registerButtonSelect = driver.findElement(By.id("submitAccount"));
        registerButtonSelect.click();
    }
}
