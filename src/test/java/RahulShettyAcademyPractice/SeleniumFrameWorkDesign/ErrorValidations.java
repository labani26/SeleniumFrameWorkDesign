
package RahulShettyAcademyPractice.SeleniumFrameWorkDesign;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import RahulShettyacademy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

    @Test
    public void SubmitOrder() throws IOException, InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String productName = "IPHONE 13 PRO";

        // Launch application
        LandingPage landingPage = launchApplication();

        // Login
        landingPage.LoginApplication(
                "maillabanisardar@gmail.com",
                "Labani@2"
        );

        Assert.assertEquals("Incorrect Email or Password", landingPage.getErrorMessage());
    }
}

