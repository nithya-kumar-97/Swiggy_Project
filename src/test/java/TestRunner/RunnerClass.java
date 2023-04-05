package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "F:\\Selenium\\com.swiggy.project\\src\\test\\java\\featureFile\\swiggy.feature", glue = "swiggy.StepDefinition", monochrome = true, plugin = {
		"pretty", "html:target/Cucumber-Reports", "pretty", "json:target/Cucumber-Reports.json" })
public class RunnerClass {

}
