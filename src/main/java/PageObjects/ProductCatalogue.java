package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstructComponents.AbstructComponent;

public class ProductCatalogue extends AbstructComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver,this);
		//this - refers to current class driver(WebDriver driver)
		//Find all the @FindBy elements and connect them with the webpage.
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
   
	@FindBy(css=".mb-3")
	List<WebElement> products;
	//List<WebElement> = plural
	
	By ProductBy = By.cssSelector(".mb-3");
	
	public List<WebElement> getProductList(){
		
		waitForElementToAppear(ProductBy);
		return products;
	}
	
}