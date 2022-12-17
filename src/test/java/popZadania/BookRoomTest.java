package popZadania;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import popZadania.pages.AuthenticationPage;
import popZadania.pages.HotelSelectionPage;
import popZadania.pages.SearchBar;

import java.time.Duration;

public class BookRoomTest {

    @Test
    public void bookRoomTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");

        String hotelLocation = "Gdansk";
        String checkInDate = "25-12-2022";
        String checkOutDate = "31-12-2022";
        String hotelName = "The Hotel Prime";

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        SearchBar searchBar = new SearchBar(driver);

        authenticationPage.loginAs("userrandom666@mail.com", "solidasarock666");
        WebElement goHome = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a/span"));
        goHome.click();

        searchBar.searchHotel(hotelLocation, checkInDate, checkOutDate, hotelName);

        HotelSelectionPage hotelSelectionPage = new HotelSelectionPage(driver);
        hotelSelectionPage.selectRoom("Delux Rooms");
        WebElement confirmationMessage = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // konstruktor waita
        wait.until(ExpectedConditions.textToBePresentInElement(confirmationMessage,"Room successfully added to your cart"));
        Assertions.assertTrue(confirmationMessage.getText().contains("Room successfully added to your cart"));
    }
}
