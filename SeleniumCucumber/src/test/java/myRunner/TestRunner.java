package myRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="F:\\QA All\\EclipseAutomationTask\\SeleniumCucumber\\features\\Customers.feature",
		glue="stepDefinations",
		dryRun=false,		 
		monochrome=true,
		plugin={"pretty","html:target/html-output.html"}

		)

public class TestRunner {

}
