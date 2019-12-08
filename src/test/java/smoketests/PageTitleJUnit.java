package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

    @Test
    public void pageTitleTest(){
        System.out.println("Running the test");
        String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

        WebDriver driver = utilities.DriverFactory.open("chrome");
        driver.get(webURL);

        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";

        Assert.assertEquals(actualTitle, expectedTitle);
        // Assert.fail("Fail by purpose");

    }

    @Before
    public void setUp(){
        System.out.println("Setting up the test");
        System.out.println("Initializing the driver");
    }

    @After
    public void tearDown(){
        System.out.println("Closing the test");
        System.out.println("Closing the driver");
    }

}
