import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {
        // 1. Define the web browser (= set the system properties of chrome driver and specifying the path to it)
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        // Creating a object to instantiate the browser driver
        WebDriver driver = new ChromeDriver();

        // 2. Open web browser and navigate to the page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // Find elements: Locate the element, Determine the action, Pass any parameters

        // 3. Enter email address
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        // 4. Enter password
        driver.findElement(By .name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        // 5. Click login
        driver.findElement(By .name("ctl00$MainContent$btnLogin")).click();

        // 6. Get confirmation
        String message = driver.findElement(By .id("conf_message")).getText();
        System.out.println("CONFIRMATION: " + message);

        String pageTitle = driver.getTitle();
        System.out.println("PAGE TITLE: " + pageTitle);

        // 7. Close the browser
        driver.close();
    }
}
