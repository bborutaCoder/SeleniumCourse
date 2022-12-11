package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Zadanie4 {

    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        String email = "test123asdQWEpoaaab@test.com";
        String password = "admin1";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl//en/");

        WebElement SingInElement = driver.findElement(By.className("hide_xs"));
        SingInElement.click();
        WebElement emailAdress = driver.findElement(By.id("email_create"));
        emailAdress.sendKeys(email);
        WebElement createAnAccont = driver.findElement(By.id("SubmitCreate"));
        createAnAccont.click();

        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        if(firstNameElement.isDisplayed()) {
            firstNameElement.sendKeys(firstName);
        }else {
            System.out.println("First name is not displayed");
        }
        WebElement lastNameElement = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        if(lastNameElement.isDisplayed()) {
            lastNameElement.sendKeys(lastName);
        }else {
            System.out.println("Last name is not displayed");
        }
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        if(emailElement.isDisplayed()) {
            emailElement.clear();
            emailElement.sendKeys(email);
        }else {
            System.out.println("E-mail is not displayed");
        }
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        if(passwordElement.isDisplayed()) {
            passwordElement.sendKeys(password);
        }else {
            System.out.println("Password is not displayed");
        }
        WebElement daySelectElement = driver.findElement(By.id("days"));
        Select daySelect = new Select(daySelectElement);
        daySelect.selectByValue("16");

        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
        if(!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }

        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
    }
}
