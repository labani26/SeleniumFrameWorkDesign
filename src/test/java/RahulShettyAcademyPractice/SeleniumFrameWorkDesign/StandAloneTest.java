package RahulShettyAcademyPractice.SeleniumFrameWorkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");

        System.out.println(driver.getTitle());

        driver.findElement(By.id("userEmail")).sendKeys("mail2labanisardar@gmail.com");
        
        driver.findElement(By.id("userPassword")).sendKeys("Labani@26");
        
        driver.findElement(By.id("login")).click();
        
        List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
        
        WebElement prod = Products.stream()
                .filter(product -> product.findElement(By.cssSelector("b"))
                        .getText()
                        .equals("iphone 13 pro"))
                .findFirst()
                .orElse(null);
        driver.findElement(By.cssSelector(".btn.w-10.rounded:last-of-type")).click();
        //:last-of-type → select the last element of that HTML tag type
    }
}