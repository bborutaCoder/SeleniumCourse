package popZadania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchBar {

    private WebDriver driver;

    public SearchBar(WebDriver driver) {
        this.driver = driver;
    }

    public void searchHotel(String hotelLocation, String checkInDate, String checkOutDate, String hotelName){

        WebElement hotelLocationElement = driver.findElement(By.id("hotel_location"));
        hotelLocationElement.sendKeys(hotelLocation);
        WebElement checkInDateElement = driver.findElement(By.id("check_in_time"));
        checkInDateElement.sendKeys(checkInDate);
        WebElement checkOutDateElement = driver.findElement(By.id("check_out_time"));
        checkOutDateElement.sendKeys(checkOutDate);
        WebElement hotelnameElement = driver.findElement(By.id("hotel_cat_name"));
        hotelnameElement.click();

        // sposob 1 - przez xpath
        //hotelnameElement.findElement(By.xpath("//*[@id=\"search_hotel_block_form\"]//li[text()='"+ hotelName +"']")).click();

        // sposob 2 - przez liste
        // //*[@id="search_hotel_block_form"]//ul//li
        List<WebElement> hotels = driver.findElements(By.xpath("//*[@id=\"search_hotel_block_form\"]//ul//li"));

        // sposob 2.1 - zwykly for
//        for (int i = 0; i < hotels.size(); i++) {
//            if (hotels.get(i).getText().contains(hotelName)) {
//                hotels.get(i).click();
//                break;
//            }
//        }

        // sposob 2.2 - for (foreach)
        for (WebElement hotel : hotels) {
            if (hotel.getText().contains(hotelName)) {
                hotel.click();
                break;
            }
        }

        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));
        searchNowButton.click();
    }
}
