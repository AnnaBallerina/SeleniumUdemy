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
        String gender = "Female";
        boolean weeklyEmail = true;
        boolean monthlyEmail = false;
        boolean occasionalEmail = false;

        // Define web driver
        WebDriver driver;
        driver = utilities.DriverFactory.open(browser);
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

        // Define Web Elements
        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
        WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.name("ctl00$MainContent$menuCountry"));
        WebElement maleGender = driver.findElement(By.name("ctl00$MainContent$Gender"));
        WebElement femaleGender = driver.findElement(By.id("MainContent_Female"));
        WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
        WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));

        // Fill out the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);

        // Select
        new Select(countryElement).selectByVisibleText(country);

        // Radio Button Algorithm
        if(gender.equalsIgnoreCase("Male")){
            maleGender.click();
        }else{
            femaleGender.click();
        }

        // Check Box Algorithm
        if(weeklyEmail){
            if(!weeklyCheckbox.isSelected()){
                weeklyCheckbox.click();
            }
        }else{
            if(weeklyCheckbox.isSelected()){
                weeklyCheckbox.click();
            }
        }

        submitButton.click();

        // Get confirmation and Close browser
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";
        if(conf.equals(expected)){
            System.out.println("CONFIRMATION: " + conf);
        }else{
            System.out.println("TEST FAILED");
        }

        driver.close();

    }
}
