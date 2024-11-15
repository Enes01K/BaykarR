package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "junit:target/cucumber-reports.xml",
                "pretty"
        },
        features ="src/test/resources/features",
        glue = "stepdefinition",
        tags = "@test",
        dryRun=false
)
public class Runner {
}
