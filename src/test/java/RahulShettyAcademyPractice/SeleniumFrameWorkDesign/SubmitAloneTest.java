
package RahulShettyAcademyPractice.SeleniumFrameWorkDesign;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

    @Test
    public void SubmitOrder() throws IOException, InterruptedException {


        
        
        landingPage = launchApplication();

        ProductCatalogue productCatalogue = landingPage.LoginApplication(
                "mail2labanisardar@gmail.com",
                "Labani@26"
        );

        // Add product to cart
        productCatalogue.AddProductToCart(productName);

        // Go to Cart
        CartPage cartPage = productCatalogue.goToCartPage();

        // Verify product is displayed in cart
        Boolean match = cartPage.VerifyProductDisplay(productName);
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
    
    
}


