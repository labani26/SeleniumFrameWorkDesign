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
	
	@FindBy(css=".ng-animating")
	List<WebElement> Spinner;
	
	By ProductBy = By.cssSelector(".mb-3");
	By ProductAddToCart = By.cssSelector("button:last-of-type");
	By ToastMessage = By.cssSelector("#toast-container");
	By ProductIs = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList(){
		
		waitForElementToAppear(ProductBy);
		return products;
	}
	
	public List<WebElement> ProductList(){
		waitForElementToDisappear(ProductIs);
		return Spinner;
	}
	
	public WebElement GetProductByName(String ProductName) {
		
		WebElement prod = products.stream()
                .filter(product -> product.findElement(By.cssSelector("b"))
                .getText().equalsIgnoreCase(ProductName)).findFirst().orElseThrow();
		
		return prod;
	}
	
	public void AddProductToCart(String ProductName) {
		
		WebElement prod = GetProductByName(ProductName);
		prod.findElement(ProductAddToCart).click();
		waitForElementToAppear(ToastMessage);
		waitForElementToDisappear(ProductIs);
		
	}
	
	
	
}