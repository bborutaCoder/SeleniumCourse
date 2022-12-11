package taskCheckConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://coderslab.pl/pl");
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        driver.quit();
    }
}
