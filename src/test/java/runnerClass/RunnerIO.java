package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		//features = ".\\src\\test\\java\\featureFiles\\LoginPage.feature",
		//features = ".\\src\\test\\java\\featureFiles\\LoginPageCopy.feature",
		features = ".\\src\\test\\java\\featureFiles\\AddProductToCart.feature",
		//features = ".\\src\\test\\java\\featureFiles\\HomePage.feature", // this is for second testcase - HomePage Validation
		glue = "stepDefinitions",
		plugin = {"pretty","html:ReportSwagLabs.html"},
		dryRun = false,
		monochrome = true,
		tags = "@Smoke or @Regression"
		
				//TRUE - no launch browser - undefined step exception - generate the methods
				//FALSE - Browser will launch and step definitions will execute
		
		)

public class RunnerIO extends AbstractTestNGCucumberTests
{
	

}
