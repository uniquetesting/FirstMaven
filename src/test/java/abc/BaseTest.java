package abc;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by E7440 on 30/06/2018.
 */
public class BaseTest extends Utils  {

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce.com/");

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
