package popZadania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelSelectionPage {

    private WebDriver driver;
    public HotelSelectionPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectRoom(String roomName){
        String bookRoomSelector = "//*[@id=\"category_data_cont\"]//p[text()='"+roomName+"']/..//a[@class='btn btn-default button button-medium ajax_add_to_cart_button pull-right']/span";
        WebElement bookNowButton = driver.findElement(By.xpath(bookRoomSelector));
        bookNowButton.click();


    }
}
