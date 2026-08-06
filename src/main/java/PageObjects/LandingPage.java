package PageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstructComponents.AbstructComponent;

public class LandingPage extends AbstructComponent {
	
	//public Means: This class can be used from anywhere in the project.
	
	WebDriver driver;
	//Class variable
	
	//constructor
	public LandingPage(WebDriver driver) {
		
		 super(driver);
		 //super(driver) : driver - Constructor parameter
		 
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver,this);
		//this - refers to current class driver(WebDriver driver)
		//PageFactory.initElements(driver,this); - Selenium connects all functions to the actual webpage.
		//PageFactory.initElements(driver,this); - Find all the @FindBy elements and connect them with the webpage.
	 
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
    	//You are not creating another browser , You are only creating another Java object.
    	//The browser is now on the Product Catalogue page,
    	//so create the Java object that represents that page.
    	return productCatalogue;
     	//We return productCatalogue because after a successful login, 
    	//the browser navigates to the Product Catalogue page.
    	//To interact with that new page, we need its Page Object.
    }
    
    public void goTo() {
    	
    	 driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }
}