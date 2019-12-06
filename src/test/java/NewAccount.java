import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import

public class NewAccount {
    public static void main(String[] args) {
        String name = "Hana Chai";
        String email = "hana.chai@gmail.com";
        String phoneNumber = "123412341234";
        String password = "mspass";
        String country = "Germany";
        String browser = "firefox";
        WebDriver driver;

        String gender;
        String weeklyEmail;
        String occasionalEmail;

        // ?? utilities is not seen
        driver = utilities.DriverFactory.open(browser);


        // 2. Open browser to navigate to Account Management Page >> Click on Create Account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
//        driver.findElement(By.linkText("Create Account")).click(); // doesn't work
//        driver.findElement(By.linkText("CREATE ACCOUNT")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

        // 3. Fill out the form

        // How locate the elements
        driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys(name);
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);

        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys(phoneNumber);

        driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']")).sendKeys(password);
        driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys(password);

        // How to interact with other HTML elements
        driver.findElement(By.id("MainContent_Female")).click();
//            driver.findElement(By.cssSelector("input[id='MainContent_Female'][value='Female']")).click();

        // Select is used for this type of element
        new Select(driver.findElement(By.name("ctl00$MainContent$menuCountry"))).selectByVisibleText(country);

        driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
        driver.findElement(By.id("MainContent_btnSubmit")).click();

        // 4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION: " + conf);

        // 5. Close the browser
        driver.close();

    }
}
