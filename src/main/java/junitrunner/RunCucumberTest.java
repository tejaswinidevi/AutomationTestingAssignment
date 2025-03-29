package junitrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features", // Path to your feature files
    glue = "StepDefinitions", // Path to your step definitions
    tags = "@PasswordStrengthValidations"
)
public class RunCucumberTest {
}