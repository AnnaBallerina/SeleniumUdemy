package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
    WebDriver driver;

    @Test
    public void loginElementsPresentTest(){
        System.out.println("Running test");

        boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
        boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();

        Assert.assertTrue(loginEmailBox, "Email Testbox not present");
        Assert.assertTrue(passwordBox, "Password Box not present");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Starting test");
        String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

        driver = utilities.DriverFactory.open("chrome");
        driver.get(webURL);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing test");
        driver.close();
    }
}
