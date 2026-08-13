
package RahulShettyAcademyPractice.SeleniumFrameWorkDesign;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;
import RahulShettyacademy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    
    public void LoginErrorValidation() throws IOException, InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        String productName = "IPHONE 13 PRO";

        // Launch application
        LandingPage landingPage = launchApplication();

        // Login
        landingPage.LoginApplication(
                "maillabanisardar@gmail.com",
                "Labani@2"
        );

        Assert.assertEquals("Incorrect Email or Password", landingPage.getErrorMessage());
    }
    
    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException {
    	
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
        CartPage cartPage = productCatalogue.goToCartPage();

        // Verify product is displayed in cart
        Boolean match = cartPage.VerifyProductDisplay("IPHONE 13 PRRO");
        Assert.assertTrue(match);

       
    }
}

