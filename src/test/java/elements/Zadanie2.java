package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationElement = driver.findElement(By.name("hotel_location"));
        WebElement searchNowElement = driver.findElement(By.name("search_room_submit"));
        WebElement enterYourEmailElement = driver.findElement(By.name("email"));
        WebElement subscribeElement = driver.findElement(By.name("submitNewsletter"));

        hotelLocationElement.sendKeys("Warsaw");
        enterYourEmailElement.sendKeys("test@test.com");

        searchNowElement.click();

        driver.quit();
    }
}
