package PageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstructComponents.AbstructComponent;

public class LandingPage extends AbstructComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		 super(driver);
		 
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver,this);
		//this - refers to current class driver(WebDriver driver)
		//Find all the @FindBy elements and connect them with the webpage.
	 
	}

    //WebElement Email = driver.findElement(By.id("userEmail"));
    
    @FindBy(id="userEmail")
    WebElement UserEmail;
    
    @FindBy(id="userPassword")
    WebElement UserPassword;
    
    @FindBy(id="login")
    WebElement Submit;
    
    public ProductCatalogue LoginApplication(String Email, String Password) {
    
    	UserEmail.sendKeys(Email);
    	UserPassword.sendKeys(Password);
    	Submit.click();
    	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
    	return productCatalogue;
     	
    }
    
    public void goTo() {
    	
    	 driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }
}