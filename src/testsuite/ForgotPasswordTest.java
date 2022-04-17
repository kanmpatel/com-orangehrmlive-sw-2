package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //click on the ‘Forgot your password’ link
        //find the element of forgot your password
        WebElement forgotYourPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
        forgotYourPasswordLink.click();
        //this os form requirement
        String expectedforgotPasswordText = "Forgot Your Password?";
        //find the forgot text element and get the text
        WebElement actualforgotPasswordTextEelemts = driver.findElement(By.xpath("//div[@class='head']"));
        String actualforgotPasswordText = actualforgotPasswordTextEelemts.getText();
        //Verify the text error message with assert
        Assert.assertEquals(expectedforgotPasswordText,actualforgotPasswordText);
    }

    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }

}
