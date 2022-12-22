package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/salario_liquido.feature"},
        glue = {"gherkin"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/output/report.html", "json:target/cucumber-report.json:"},
        dryRun = false
)
public class Runner {

}
