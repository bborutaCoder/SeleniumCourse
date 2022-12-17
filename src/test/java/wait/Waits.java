package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        // pierwszy sposob, robi sie to raz na test
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.webdriveruniversity.com/Ajax-Loader/index.html");

        WebElement button = driver.findElement(By.id("button1"));

        // explicitly wait - tutaj podajemy na jedno zdarzenie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        button.click();
    }
}

