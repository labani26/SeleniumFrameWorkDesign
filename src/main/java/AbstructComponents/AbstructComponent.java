package AbstructComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.CartPage;

public class AbstructComponent {

    WebDriver driver;
    WebDriverWait wait;

    public AbstructComponent(WebDriver driver)
    //constructor
    {
    	//initialization
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @FindBy(css="\"[routerlink*='cart']\"")
    WebElement CartHeader;

    public void waitForElementToAppear(By findBy)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    
    public void waitForElementToDisappear(By findBy) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    	
    }
    
    public PageObjects.CartPage CartPage() {
    	CartHeader.click();
    	CartPage cartPage = new CartPage(driver);
    	return cartPage;
    }
}