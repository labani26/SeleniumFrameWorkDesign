package RahulShettyAcademyPractice.SeleniumFrameWorkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;

public class SubmitAloneTest {
	
	static String ProductName = "IPHONE 13 PRO";
	
	//Because main() is static.
//A static method can directly use another static variable.
//If it weren't static, you'd first need to create an object of SubmitAloneTest.

    public static void main(String[] args) throws InterruptedException {
    	//Everything inside main() executes from top to bottom.

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LandingPage homePage = new LandingPage(driver);
        //"Create an object that represents the Login (Landing) page and give it the browser (driver) 
        //so it can interact with the page."
        
        homePage.goTo();
        
        ProductCatalogue productCatalogue = homePage.LoginApplication("mail2labanisardar@gmail.com","Labani@26");

        List<WebElement>products = productCatalogue.getProductList();
        

        productCatalogue.AddProductToCart(ProductName);
        
        CartPage cartPage = productCatalogue.CartPage();   
        
        Boolean match = cartPage.VerifyProductDisplay(ProductName);    
        Assert.assertTrue(match);
        
        CheckoutPage CheckoutPage = cartPage.GoToCheckOut();
        CheckoutPage.selectCountry("India");

        Thread.sleep(3000);   // Temporary test

        ConfirmationPage confirmationPage = CheckoutPage.PlaceOrder();
      
        String output = confirmationPage.verifyConfirmationMessage();

        Assert.assertEquals(output, "THANKYOU FOR THE ORDER.");
        
        //driver.quit();
    }
}