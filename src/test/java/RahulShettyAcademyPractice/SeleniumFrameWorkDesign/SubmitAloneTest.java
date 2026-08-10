
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
import PageObjects.ProductCatalogue;
import RahulShettyacademy.TestComponents.BaseTest;

public class SubmitAloneTest extends BaseTest {

    @Test
    public void SubmitOrder() throws IOException, InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String productName = "IPHONE 13 PRO";

        // Launch application
        LandingPage landingPage = launchApplication();

        // Login
        ProductCatalogue productCatalogue = landingPage.LoginApplication(
                "mail2labanisardar@gmail.com",
                "Labani@26"
        );

        // Add product to cart
        productCatalogue.AddProductToCart(productName);

        // Go to Cart
        CartPage cartPage = productCatalogue.CartPage();

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
}

