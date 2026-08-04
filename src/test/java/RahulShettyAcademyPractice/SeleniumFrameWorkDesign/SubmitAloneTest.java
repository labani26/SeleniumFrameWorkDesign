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
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;

public class SubmitAloneTest {
	
	static String ProductName = "IPHONE 13 PRO";

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LandingPage homePage = new LandingPage(driver);
        
        homePage.goTo();
        
        ProductCatalogue productCatalogue = homePage.LoginApplication("mail2labanisardar@gmail.com","Labani@26");

//        driver.findElement(By.id("userEmail")).sendKeys("mail2labanisardar@gmail.com");
//        driver.findElement(By.id("userPassword")).sendKeys("Labani@26");
//        driver.findElement(By.id("login")).click();
        
        List<WebElement>products = productCatalogue.getProductList();
        
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        // Wait until products are loaded
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

//        WebElement prod = products.stream()
//                .filter(product -> product.findElement(By.cssSelector("b"))
//                        .getText().equalsIgnoreCase(ProductName))
//                .findFirst()
//                .orElseThrow();
        
        //equalsIgnoreCase() - It compares two strings without considering uppercase or lowercase letters.

        // Click Add To Cart
       //  prod.findElement(By.cssSelector("button:last-of-type")).click();
        //:last-of-type → Selects the last button among its sibling buttons.

        productCatalogue.AddProductToCart(ProductName);
        
        CartPage cartPage = productCatalogue.CartPage();
        
        
        // Wait for success message
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

        // Wait until loading animation disappears
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

        // Click Cart
        //driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        // Verify product in cart
//        List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
//
//        boolean match = cartProducts.stream()
//                .anyMatch(cart -> cart.getText().equalsIgnoreCase(ProductName));        
        
        Boolean match = cartPage.VerifyProductDisplay(ProductName);    
        Assert.assertTrue(match);
        
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-toastr")));
        //Wait until the success message (green toast notification) is no longer visible.
        
     // Click Checkout
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[normalize-space()='Checkout']")));
        CheckoutPage CheckoutPage = cartPage.GoToCheckOut();
        CheckoutPage.selectCountry("India");
        ConfirmationPage CheckoutPage.PlaceOrder();
        
        
       // driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();

        // Enter country
//        WebElement country = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
//        country.sendKeys("India");
//
//        // Wait for country suggestions
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//        
//     // Click the India suggestion
//        driver.findElement(By.cssSelector(".ta-item.list-group-item.ng-star-inserted:last-child")).click();
//
//     // Wait until suggestions disappear
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ta-results")));

        // Wait until Place Order button is clickable
//        WebElement placeOrder = wait.until(
//                ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
//
//        // Click Place Order
//        placeOrder.click();

        // Verify confirmation
        String output = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")))
                .getText();

        Assert.assertEquals(output, "THANKYOU FOR THE ORDER.");
        
        driver.quit();
    }
}