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

    // Constructor
    public AbstructComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Cart button
    @FindBy(css = "[routerlink*='cart']")
    WebElement CartHeader;

    // Wait until element is visible
    public void waitForElementToAppear(By findBy) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    
    // Wait until element is visible
    public void waitForWebElementToAppear(WebElement findBy) {

        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    // Wait until element disappears
    public void waitForElementToDisappear(By findBy) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    // Wait until element is clickable
    public void waitForElementToBeClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Go to Cart Page
    public CartPage CartPage() {

        CartHeader.click();
        return new CartPage(driver);
    }
}