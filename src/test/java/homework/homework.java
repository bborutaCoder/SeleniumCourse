package homework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class homework {

    private static WebDriver driver;

    @BeforeAll
    public static void classSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @AfterAll
//    public static void classTearDown() {
//        driver.quit();
//    }

    @Test
    public void createNewAccount(){
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signIn.click();
        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        createAccount.click();
        driver.navigate().back();
        driver.navigate().back();
    }

    @Test
    public void  form(){
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        firstName.sendKeys("Karol");
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        lastName.sendKeys("Kowalski");
        WebElement gender = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"));
        gender.click();
        WebElement birthDate = driver.findElement(By.xpath("//*[@id=\"dob\"]"));
        birthDate.sendKeys("05/22/2010");
        WebElement address = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        address.sendKeys("Prosta 51");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("karol.kowalski@mailinator.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("Pass123");
        WebElement company = driver.findElement(By.xpath("//*[@id=\"company\"]"));
        company.sendKeys("Coders Lab");
        WebElement comment = driver.findElement(By.xpath("//*[@id=\"comment\"]"));
        comment.sendKeys("To jest mój pierwszy automat testowy");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submitButton.click();
    }
    @Test
    public void xpathFind(){
        driver.get("https://mystore-testlab.coderslab.pl//index.php?controller=authentication&create_account=1");
        WebElement socialStatus = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[1]/label"));
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[2]/label"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[3]/label"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[4]/label"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[4]/label"));
        WebElement show = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[5]/div[1]/div/span/button"));
        WebElement birthdate = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[6]/label"));

    }

    @Test
    public void registerUser() {

        //Arrange
        String[] firstName = {"John", "Chosen", "Sulik"};
        String[] lastName = {"Doe", "One", "GrampyBone"};
        String[] password = {"admin1", "waterchip13", "geck9"};
        String[] birthdate = {"10/10/2010", "5/5/2000", "1/1/6666"};
        String email = generateEmail();

        // Act

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signIn.click();
        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        createAccount.click();

        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id=\"field-firstname\"]"));
        firstNameElement.sendKeys(firstName[generateRandomNumber()]);

        WebElement lastNameElement = driver.findElement(By.xpath("//*[@id=\"field-lastname\"]"));
        lastNameElement.sendKeys(lastName[generateRandomNumber()]);

        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"field-email\"]"));
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"field-password\"]"));
        passwordElement.sendKeys(password);
        WebElement birthdateElement = driver.findElement(By.xpath("//*[@id=\"field-birthday\"]"));
        birthdateElement.sendKeys(birthdate[generateRandomNumber()]);
    }

    private String generateEmail() {
        String randomName = "user_";
        Random r = new Random();
        int number = r.nextInt(1000000);
        randomName += number;
        String domain = "@mailTest.com";

        return randomName + domain;
    }
    private int generateRandomNumber(){
        Random rand = new Random();
        int upperbound = 3;
        int random = rand.nextInt(upperbound);

        return random;
    }
}

