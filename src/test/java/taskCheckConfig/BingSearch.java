package taskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingSearch {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.bing.com");
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Selenium");
        element.submit();
        driver.quit();
    }
}
