package mavenfirstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Testsuite extends BaseTest
{

    @Test
    public void VerifyUserShouldBeAbleToRegisterSuccessfully()
    {
        ClickOnElement(By.linkText("Register"));
        ClickOnElement(By.id("gender-female"));
        EnterText(By.id("FirstName"), "Meera");
        EnterText(By.id("LastName"), "Shah");
        SelectFromDropdown("DateOfBirthDay", "13");
        SelectFromDropdown("DateOfBirthMonth", "June");
        SelectFromDropdown("DateOfBirthYear", "1970");


//        EnterText(By.id("Email"), "meerashah040720181753@gmail.com");

        String email = "meerashah"+timeStamp() +"@gmail.com";
        clearAndEnterText(By.id("Email"),email);

        EnterText(By.id("Company"),"SoftwareTesting");
        ClickOnElement(By.id("Newsletter"));
        EnterText(By.id("Password"),"Abc1234");
        EnterText(By.id("ConfirmPassword"), "Abc1234");
        ClickOnElement(By.id("register-button"));

        waitForElementDisplay(By.xpath("//div[@class='page-title']"),10);
        String expectedConfirmationMsg = "Your registration completed";
        Assert.assertEquals(GetTextFromElement(By.className("result")),expectedConfirmationMsg);
    }

    @Test
    public void VerifyUserShouldBeAbleToCompare2Items() {
        ClickOnElement(By.xpath("//*[@class='button-2 add-to-compare-list-button'][1]"));
        ClickOnElement(By.linkText("product comparison"));
       driver.navigate().back();
        // ClickOnElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        // I tried here to use explicity wait but it does not work so i am going back to main page and asking driver to click on virtual gift card compare button.
        ClickOnElement(By.xpath("//*[@class='item-grid']/div[4]/div/div[2]/div[3]/div[2]/input[2]"));

        waitForElementDisplay(By.className("content"),10);

        Assert.assertEquals(GetTextFromElement(By.className("content")),"The product has been added to your product comparison");
        ClickOnElement(By.linkText("product comparison"));

        String expectedCompareMsg ="Compare products";
        Assert.assertEquals(getText(By.xpath("//div[@class='page-title']")),expectedCompareMsg);
    }

    @Test
    public  void VerifyUserShouldBeAbleToClearCompareProductList()
    {
        ClickOnElement(By.xpath("//*[@class='button-2 add-to-compare-list-button'][1]"));
        ClickOnElement(By.linkText("product comparison"));
        ClickOnElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        ClickOnElement(By.xpath("//*[@class='item-grid']/div[4]/div/div[2]/div[3]/div[2]/input[2]"));

        waitForElementDisplay(By.className("content"),10);

        Assert.assertEquals(GetTextFromElement(By.className("content")),"The product has been added to your product comparison");
        ClickOnElement(By.linkText("product comparison"));
        ClickOnElement(By.className("clear-list"));
        Assert.assertEquals(GetTextFromElement(By.className("no-data")),"You have no items to compare.");
    }

    @Test
    public void VerifyUserShouldBeAbleToSortBooksCategoryByLowtohighAndCompareTheValues()
    {
        ClickOnElement(By.linkText("Books"));
        SelectFromDropList("products-orderby",3);
        SelectFromDropList("products-pagesize",0);

        String firstProductPriceText = getText(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/span[2]"));
        String lastProductPriceText = getText(By.xpath("//div[3]/div/div[2]/div[3]/div[1]/span[2]"));
        double firstProductPrice=Double.parseDouble(firstProductPriceText.replace("$",""));
        double lastProductPrice=Double.parseDouble(lastProductPriceText.replace("$",""));

        Assert.assertTrue(lastProductPrice>firstProductPrice);
        System.out.println(firstProductPrice + ":"+lastProductPrice);

//        Assert.assertEquals(GetTextFromElement(By.className("prices")),"$35.00 $24.00");
//        Assert.assertEquals(GetTextFromElement(By.xpath("//*[contains(text(),'$51.00')]")),"$51.00");
    }

    @Test
    public void VerifyUserShouldBeAbleToSeeAppleIcamInShoppingList()
    {
        ClickOnElement(By.linkText("Electronics"));
        ClickOnElement(By.linkText("Camera & photo"));
        ClickOnElement(By.linkText("Apple iCam"));
        ClickOnElement(By.id("add-to-cart-button-17"));

        waitForElementDisplay(By.className("content"),10);

        Assert.assertEquals(GetTextFromElement(By.className("content")),"The product has been added to your shopping cart");
        ClickOnElement(By.linkText("shopping cart"));
        Assert.assertEquals(GetTextFromElement(By.className("sku-number")),"APPLE_CAM");
        }
    }



