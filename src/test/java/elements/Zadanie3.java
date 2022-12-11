package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie3 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl//en/");
        WebElement signInButton = driver.findElement(By.className("hide_xs"));
        signInButton.click();
        WebElement emailAdress = driver.findElement(By.id("email_create"));
        emailAdress.sendKeys("test2321321@mail3123.com");
        WebElement createAccount = driver.findElement(By.id("SubmitCreate"));
        createAccount.click();
    }
}
