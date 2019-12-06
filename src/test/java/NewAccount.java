import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {
    public static void main(String[] args) {
        String name = "Hana Chai";
        String email = "hana.chai@gmail.com";
        String phoneNumber = "123412341234";
        String password = "mspass";
        String country = "Germany";
        String browser = "firefox";
        WebDriver driver;
        driver = utilities.DriverFactory.open(browser);

        String gender;
        String weeklyEmail;
        String occasionalEmail;

        // Open browser to navigate to Account Management Page >> Click on Create Account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

        // Define Web Elements
        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
        WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.name("ctl00$MainContent$menuCountry"));

        // Fill out the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);  // select type of element

        // How to interact with other HTML elements
        driver.findElement(By.id("MainContent_Female")).click();
        // driver.findElement(By.cssSelector("input[id='MainContent_Female'][value='Female']")).click();

        driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
        driver.findElement(By.id("MainContent_btnSubmit")).click();

        // Get confirmation and Close browser
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION: " + conf);
        driver.close();

    }
}
