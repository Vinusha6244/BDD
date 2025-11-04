package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = "featurefiles",
		glue={"stepdefinitions","hooks"},
		dryRun = true,
		monochrome = true, 
		plugin ={"html:target/report.html","json:target/report.json"},
		tags="@Zomato"
)
public class Runner extends AbstractTestNGCucumberTests{

}