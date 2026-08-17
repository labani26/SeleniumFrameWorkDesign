
package RahulShettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;
    public LandingPage homePage;

    public WebDriver initializeDriver() throws IOException {	
//    	initializeDriver()
//    	This method will perform your browser setup.

        // Properties class
        Properties prop = new Properties();
        //This creates a Properties object.
//        We will use it to read your:
//        Globaldata.properties

        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir")
                + "\\src\\main\\java\\RahulShettyAcademy\\resources\\Globaldata.properties"
        );
        //This opens your Globaldata.properties file so Java can read it.

        prop.load(file);
//        This reads the contents of:
//        Globaldata.properties

        String browserName = prop.getProperty("Browser");
//        This searches the properties file for:
//        Browser

        if (browserName.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("Firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("Edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
    }
    
    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

    	//read json to string
        String JsonContent = FileUtils.readFileToString(
                new File(System.getProperty("user.dir")
                + "\\src\\test\\java\\RahulShettyacademy\\data\\PurchaseOrder.json"),
                StandardCharsets.UTF_8);
        
//StandardCharsets.UTF_8 : simply tells Java how to read the text inside your JSON file.
        
        //String to hashMap Jackson databind 
        
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>>data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>(){
        	
        });

        return data;
    }
    
    @BeforeMethod(alwaysRun = true)
    
    public LandingPage launchApplication() throws IOException {
    	
    	driver = initializeDriver();
         homePage = new LandingPage(driver);
          //"Create an object that represents the Login (Landing) page and give it the browser (driver) 
          //so it can interact with the page."
        homePage.goTo();
        return homePage;
    	
    }
    
    @AfterMethod(alwaysRun = true)
    
    public void TearDown() {
    	
    	driver.close();
    	
    }
}



