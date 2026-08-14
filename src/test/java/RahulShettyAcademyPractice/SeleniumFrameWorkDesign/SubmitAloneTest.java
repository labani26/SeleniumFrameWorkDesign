
package RahulShettyAcademyPractice.SeleniumFrameWorkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import PageObjects.LandingPage;
import PageObjects.OrderPage;
import PageObjects.ProductCatalogue;
import RahulShettyacademy.TestComponents.BaseTest;

public class SubmitAloneTest extends BaseTest {

	String productName = "IPHONE 13 PRO";
	
    LandingPage landingPage;

    @Test(dataProvider="getData", groups="Purchase")
    
    public void SubmitOrder(HashMap <String,String> input)  throws IOException, InterruptedException {

 
        landingPage = launchApplication();

        ProductCatalogue productCatalogue = landingPage.LoginApplication(input.get("Email"),input.get("Password"));

        // Add product to cart
        productCatalogue.AddProductToCart(input.get("Product"));

        // Go to Cart
        CartPage cartPage = productCatalogue.goToCartPage();

        // Verify product is displayed in cart
        Boolean match = cartPage.VerifyProductDisplay(input.get("Product"));
        Assert.assertTrue(match);

        // Go to Checkout
        CheckoutPage checkoutPage = cartPage.GoToCheckOut();

        // Select country
        checkoutPage.selectCountry("India");

//        // Temporary wait
//        Thread.sleep(3000);

        // Place order
        ConfirmationPage confirmationPage = checkoutPage.PlaceOrder();

        // Verify confirmation message
        String output = confirmationPage.verifyConfirmationMessage();

        Assert.assertEquals(output, "THANKYOU FOR THE ORDER.");
    }
    
    
    @Test(dependsOnMethods = {"SubmitOrder"})
    public void OrderHistoryTest() {

        ProductCatalogue productCatalogue = landingPage.LoginApplication(
                "mail2labanisardar@gmail.com",
                "Labani@26"
        );
        
     // Go to Order
        OrderPage orderPage = productCatalogue.goToOrderPage();
        
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

    }
    
    @DataProvider
    
    public Object [] [] getData(){
    	
    	HashMap<String,String> map = new HashMap<String,String>();
    	map.put("Email" , "mail2labanisardar@gmail.com" );
    	map.put("Password", "Labani@26");
    	map.put("Product", "IPHONE 13 PRO");
    	
    	HashMap<String,String> map1 = new HashMap<String,String>();
    	map1.put("Email" , "labanisardar@gmail.com" );
    	map1.put("Password", "Labani@26");
    	map1.put("Product", "ZARA COAT 3");
    	
    	return new Object [] [] {{map}, {map1}};
    	
    }
    
//    @DataProvider
//    public Object [][]getdata(){
//    	return new Object [][] {
//    		                    {"mail2labanisardar@gmail.com","Labani@26","ZARA COAT 3"},
//    		                    {"labanisardar@gmail.com","Labani@26","ZARA COAT 3"}
//    		                    };
//    }
//    
}


