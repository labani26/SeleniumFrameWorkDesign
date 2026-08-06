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
   
	//Because the page contains many product cards.
	@FindBy(css=".mb-3")
	List<WebElement> products;
	//List<WebElement> = plural
//products - To store the actual elements,So products contains the actual WebElements.
	
	//This represents the loading animation.
	//After loading: The spinner disappears.
	@FindBy(css=".ng-animating")
	List<WebElement> Spinner;
	
	
	//page contains many product cards.
	//ProductBy - Only stores the locator
	//This does not find any elements.It only stores: ".mb-3"
	By ProductBy = By.cssSelector(".mb-3");
	
	//Add To Cart button
	By ProductAddToCart = By.cssSelector("button:last-of-type");
	
	//✔ Product Added To Cart - That popup is the Toast Message.	
	By ToastMessage = By.cssSelector("#toast-container");
	
	//After loading: used to wait for the spinner to disappear.
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
		
//		.findFirst() - From the filtered results, give me the first matching element.
//       Java is expecting only one element.
//		IPHONE 13 PRO
//		IPHONE 13 PRO
//		findFirst() returns:
//		First IPHONE 13 PRO
//		and ignores the rest.
//		But what if there is no matching product?
//		Java cannot guarantee that one exists.So it returns an Optional.
//     	Think of Optional as a box that may or may not contain a value.
	}
	
	public void AddProductToCart(String ProductName) {
		
		WebElement prod = GetProductByName(ProductName);
		prod.findElement(ProductAddToCart).click();
		waitForElementToAppear(ToastMessage);
		waitForElementToDisappear(ProductIs);
		
	}
	
	
	
}