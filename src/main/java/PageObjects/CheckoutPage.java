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

    By selectCountryResults = By.cssSelector(".ta-results");

    @FindBy(css = ".ta-item.list-group-item.ng-star-inserted:last-child")
    WebElement selectCountry;
    
    @FindBy(css=".action__submit")
    WebElement OrderSubmit;

    public void selectCountry(String countryName) {

        Actions action = new Actions(driver);
        action.sendKeys(enterCountry, countryName).build().perform();

        waitForElementToAppear(selectCountryResults);
        selectCountry.click();
        
    }
    
    public ConfirmationPage PlaceOrder() {
    	
    	OrderSubmit.click();
    	return new ConfirmationPage(driver);
    }
}