package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find the element of username and send the email key
        WebElement UserNameElement = driver.findElement(By.id("txtUsername"));
        UserNameElement.sendKeys("Admin");
        //find the element of password and send the password key
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passwordElement.sendKeys("admin123");
        //click on loging button using elements
        WebElement login = driver.findElement(By.name("Submit"));
        login.click();
        //this os form requirement
        String expectedLogInText = "Welcome";
        //find the welcome text element and get the text
        WebElement actualLogInTextElements = driver.findElement(By.partialLinkText("Welcome"));
        String actualLogInText = actualLogInTextElements.getText();
        //Verify the text error message with assert
        Assert.assertEquals(expectedLogInText,actualLogInText.substring(0,7));
    }

    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }

}
