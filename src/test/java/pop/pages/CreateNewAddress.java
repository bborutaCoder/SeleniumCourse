package pop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAddress {
    private WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement zipInput;

    @FindBy(id = "field-id_country")
    private WebElement countryInput;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveAddressButton;


    public CreateNewAddress(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void saveNewAddress(String alias, String address, String city,
                               String zip, String country, String phone){

        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipInput.sendKeys(zip);
        countryInput.sendKeys(country);
        phoneInput.sendKeys(phone);

        saveAddressButton.click();

    }

}
