package us.abstracta.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "us.abstracta.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunCucumberTest {
}
