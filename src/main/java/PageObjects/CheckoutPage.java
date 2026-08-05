package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstructComponents.AbstructComponent;

public class CheckoutPage extends AbstructComponent {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement enterCountry;

    @FindBy(css = ".ta-item")
    WebElement selectCountry;

    @FindBy(css = ".action__submit")
    WebElement OrderSubmit;

    By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {

        Actions action = new Actions(driver);
        action.sendKeys(enterCountry, countryName).build().perform();

        waitForElementToAppear(results);

        selectCountry.click();

        // Wait until the dropdown disappears
        waitForElementToDisappear(results);
    }

    public ConfirmationPage PlaceOrder() {

        waitForElementToBeClickable(OrderSubmit);

        OrderSubmit.click();

        return new ConfirmationPage(driver);
    }
    
    
}