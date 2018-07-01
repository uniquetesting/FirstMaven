package abc;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by E7440 on 30/06/2018.
 */
public class TestSuite extends BaseTest {

    @Test // This is a test method
    public void verifyUserShouldBeOnHomePage ()
    {

        Assert.assertEquals(getTextFromElement(By.linkText("Register")),"Register");


    }

    @Test // This is a test method
    public void verifyUserShouldBeAbleToRegisterSuccessfully ()
    {

        clickOnElement(By.linkText("Register"));
        entertext(By.name("FirstName"),"Raj");
        entertext(By.name("LastName"), "Patel");
        waitForElementToBeClickable(By.id("Submit1"),20);
        Assert.assertEquals(getTextFromElement(By.linkText("Register")),"Register");

    }



}
