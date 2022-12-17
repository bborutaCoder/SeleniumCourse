package popZadania;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import popZadania.pages.AuthenticationPage;
import popZadania.pages.SearchBar;

import java.time.Duration;

public class LoginTest {

    @Test
    public void loginTest(){
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
    }
}
