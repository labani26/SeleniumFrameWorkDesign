package AbstructComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstructComponent {

    WebDriver driver;
    WebDriverWait wait;

    public AbstructComponent(WebDriver driver)
    //initialization
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementToAppear(By findBy)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
}