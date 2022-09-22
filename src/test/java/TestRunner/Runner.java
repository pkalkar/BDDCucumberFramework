
package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue={"StepDefinition"},
		dryRun = false,
		monochrome = true,
		tags = "@Sanity",
		plugin={"pretty","html:target/cucumber-report/Report.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumber:"}
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
		

public class Runner extends AbstractTestNGCucumberTests {

	
}
