package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        // wyszukiwanie elementow po id

        // pole Hotel Location
        WebElement hotelLocationElement = driver.findElement(By.id("hotel_location"));
        // wpisanie tekstu do elementu
        hotelLocationElement.sendKeys("Warsaw");

        // znalezienie przycisku Search Now
        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));

        // znalezienie przycisku Enter your e-mail (na dole strony)
        WebElement enterYourEmailBottomElement = driver.findElement(By.id("newsletter-input"));
        // wpisanie maila w pole
        enterYourEmailBottomElement.sendKeys("test@test.com");

        searchNowButton.click();

        driver.quit();
    }
}
