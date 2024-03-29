package cucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/features",
        glue = "stepsImplementations",
        junit = {"--filename-compatible-names"}
)
public class LoginTestRunner {
}
