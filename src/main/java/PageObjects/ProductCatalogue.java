package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver,this);
		//this - refers to current class driver(WebDriver driver)
		//Find all the @FindBy elements and connect them with the webpage.
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
   
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
}