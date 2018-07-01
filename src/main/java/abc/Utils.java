package abc;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by E7440 on 30/06/2018.
 */
public class Utils extends BasePage {

    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public static void entertext(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by){
        return driver.findElement(by).getText() ;
    }

    public static void waitForElementToBeClickable(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
