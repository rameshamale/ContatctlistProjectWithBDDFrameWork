package Runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/FeatureFiles",   // Path to feature files
        glue = "Definations",                   // Path to step definitions
        plugin = {"pretty", "html:target/cucumber-reports"},  // Output format for reports
        monochrome = true                           // Readable console output
)
public class TestRunner {
}
