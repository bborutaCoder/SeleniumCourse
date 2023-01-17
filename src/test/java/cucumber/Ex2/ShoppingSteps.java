package cucumber.Ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pop.pages.Login;


import java.time.Duration;

public class ShoppingSteps {

    @Test
    public void doTheShopping() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");

        Login login = new Login(driver);
        login.loginUser("sk8_flojd@wp.pl", "Piccolo666");

        driver.findElement(By.id("category-3")).click();

        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
        searchField.sendKeys("Hummingbird Printed Sweater");
        driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/button")).click();

        driver.findElement(By.cssSelector("#js-product-list > div.products.row > div > article > div > div.thumbnail-top > a > img")).click();


        String discount = driver.findElement(By.xpath("//section//div/span[2]")).getText();
        Assertions.assertTrue(discount.contains("SAVE 20%"));

        WebElement selectSize = driver.findElement(By.id("group_1"));
        selectSize.sendKeys("M");

        WebElement quantityUpButton = driver.findElement(By.className("touchspin-up"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException reallyIgnored) {}

        quantityUpButton.click();
        quantityUpButton.click();
        quantityUpButton.click();
        quantityUpButton.click();

        driver.findElement(By.id("add-to-cart-or-refresh")).click();
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]//div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]//a")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]//div[2]/button")).click();

        WebElement deliveryOption1 = driver.findElement(By.xpath("//section//div//form/div//div//span"));
        deliveryOption1.click();

        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button")).click();

        driver.findElement(By.id("payment-option-1")).click();

        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();

        WebElement confirmationMessage = driver.findElement(By.xpath("//*[@id=\"content-hook_payment_return\"]/div/div/div/p[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(confirmationMessage,"Your order on PrestaShop is complete."));

        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source,new File("C:/Users/admin/Pictures/Test/testScreenshot.png"));

       driver.quit();

    }
}

//        Login procedure
//        WebElement emailInput = driver.findElement(By.id("field-email"));
//        emailInput.sendKeys("sk8_flojd@wp.pl");
//        WebElement passwordInput = driver.findElement(By.id("field-password"));
//        passwordInput.sendKeys("Piccolo666");
//        driver.findElement(By.id("submit-login")).click();