package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/FeatureFiles",
            glue = "Definations",
            plugin = {
                    "pretty",  // Pretty output to the console
                    "html:target/cucumber-reports/cucumber-html-report.html", // HTML report
                    "json:target/cucumber-reports/cucumber.json" // JSON report
            }
    )
    public class TestRunner {
    }

