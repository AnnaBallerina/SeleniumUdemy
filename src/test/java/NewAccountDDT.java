import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.Parameters;
import utilities.CSV;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
    String name;
    String email;
    String phone;

    // Test method
    @Test
    public void newAccountTest(){
        System.out.println("NEW RECORD: " + name + " " + email + " " + phone);
    }

    // This method is designed to pass parameters into the class via constructor
    @Parameters
    public static List<String[]> getData(){
        return CSV.get("./src/main/resources/UserAccounts.csv");
    }

    // Constructor that passes parameters to the test method
    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
                         String weeklyEmail, String monthlyEmail, String occasionalEmail) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
