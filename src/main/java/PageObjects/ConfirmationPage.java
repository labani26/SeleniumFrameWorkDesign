package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstructComponents.AbstructComponent;

public class ConfirmationPage extends AbstructComponent {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Verify confirmation message
    @FindBy(css = ".hero-primary")
    WebElement verifyConfirmation;

    public String verifyConfirmationMessage() {
        return verifyConfirmation.getText();
    }
}