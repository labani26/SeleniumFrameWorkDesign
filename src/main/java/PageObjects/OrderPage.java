package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstructComponents.AbstructComponent;

public class OrderPage extends AbstructComponent {

    WebDriver driver;

    // Constructor
    public OrderPage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Product names in Order History
    @FindBy(xpath = "//tr/td[3]")
    private List<WebElement> productNames;

    // Verify product in Order History
    public Boolean verifyOrderDisplay(String productName) {

        boolean match = productNames.stream()
                .anyMatch(order -> order.getText()
                        .equalsIgnoreCase(productName));

        return match;
    }
}