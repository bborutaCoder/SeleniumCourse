package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionsTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://pl.wikipedia.org/");
        WebElement element = driver.findElement(By.id("main-page-column1"));
        System.out.println(element.getText());

        driver.get("https://pl.wikipedia.org/");
        String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
        System.out.println(atrybut);

        driver.get("https://pl.wikipedia.org/");
        String tag = driver.findElement(By.id("main-page-content")).getTagName();
        System.out.println(tag);

        driver.get("https://pl.wikipedia.org/");
        WebElement search = driver.findElement(By.id("searchInput"));
        if (search.isDisplayed()) {
            search.sendKeys("Selenium");
            //search.submit();
            driver.findElement(By.id("searchButton")).click();
        }
        else {
            System.out.println("Element is not displayed!");
        }

        driver.quit();
    }
}
