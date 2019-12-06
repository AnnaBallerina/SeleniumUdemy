import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

    public static void main(String[] args) {
        // 1. Set the system properties of firefox driver and specifying the path to it
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // 2. Open browser to navigate to Account Management Page >> Click on Create Account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
//        driver.findElement(By.linkText("Create Account")).click(); // doesn't work
        driver.findElement(By.linkText("CREATE ACCOUNT")).click();

        // 3. Fill out the form

            // How locate the elements
            driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Hana Chai");
            driver.findElement(By.id("MainContent_txtEmail")).sendKeys("hana.chai@gmail.com");

            driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("123412341234");

            driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']")).sendKeys("mspass");
            driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("mspass");

            // How to interact with other HTML elements
            driver.findElement(By.id("MainContent_Female")).click();
//            driver.findElement(By.cssSelector("input[id='MainContent_Female'][value='Female']")).click();

            // Select is used for this type of element
            new Select(driver.findElement(By.name("ctl00$MainContent$menuCountry"))).selectByVisibleText("Germany");

            driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
            driver.findElement(By.id("MainContent_btnSubmit")).click();

        // 4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION: " + conf);

        // 5. Close the browser
        driver.close();

    }
}
