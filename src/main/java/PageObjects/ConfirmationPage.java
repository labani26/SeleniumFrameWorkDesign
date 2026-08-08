package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstructComponents.AbstructComponent;

public class ConfirmationPage extends AbstructComponent {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
    	//This constructor receives the existing driver.
    	
        super(driver);
        //AbstructComponent(driver);So the parent class receives the same driver.
        
        this.driver = driver;
        //The driver received by the constructor is stored 
        //in the ConfirmationPage object's driver.
        
        PageFactory.initElements(driver, this);
        //This connects your @FindBy elements to the webpage.
    }

    // Verify confirmation message
    @FindBy(css = ".hero-primary")
    WebElement verifyConfirmation;

    public String verifyConfirmationMessage() {
        return verifyConfirmation.getText();
    }
}