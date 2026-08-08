package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import AbstructComponents.AbstructComponent;

public class CartPage extends AbstructComponent{

	WebDriver driver;
	
	
	//constructor
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
        PageFactory.initElements(driver,this);
	}
	
	 // Verify product in car
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List<WebElement> VerifyProductInCart;
	
	// Click Checkout
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement CheckOut;
	
	//This is a locator for the animation/loading element.
	By InvisibleProduct = By.cssSelector(".ng-animating");
	
	
	//Because we're asking a yes/no question: "Is this product present in the cart?"
	public Boolean VerifyProductDisplay(String ProductName) {
		
		boolean match =  VerifyProductInCart.stream()
                .anyMatch(cart -> cart.getText().equalsIgnoreCase(ProductName));

        return match;
		
	}
	
	public CheckoutPage GoToCheckOut() {
		CheckOut.click();
		waitForElementToDisappear(InvisibleProduct);
		return new CheckoutPage(driver);
	}
	

}
