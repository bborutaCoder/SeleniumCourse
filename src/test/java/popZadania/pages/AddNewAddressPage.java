package popZadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressPage {

    private WebDriver driver;

    @FindBy(id = "address1")
    private WebElement addressLine1Input;

    @FindBy(id = "postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_country")
    private WebElement countryDropDown;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasInput;

    @FindBy(id = "submitAddress")
    private WebElement saveButton;

    public AddNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewAddress(
            String street,
            String postalCode,
            String city,
            String country,
            String homePhone,
            String title) {
        addressLine1Input.sendKeys(street);
        postalCodeInput.sendKeys(postalCode);
        cityInput.sendKeys(city);
        countryDropDown.sendKeys(country);
        homePhoneInput.sendKeys(homePhone);
        aliasInput.clear();
        aliasInput.sendKeys(title);

        saveButton.click();
    }
}
