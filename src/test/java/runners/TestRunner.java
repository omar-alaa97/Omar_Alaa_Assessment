package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "steps", tags = "@Images",
        plugin = {"pretty", "html:target/reports/reports.html", "json:target/reports/reports.json"})
public class TestRunner {
}
