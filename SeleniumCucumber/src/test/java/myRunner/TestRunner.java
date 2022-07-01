package myRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//features/",
		glue="stepDefinations",
		dryRun=false,		 
		monochrome=true,
		plugin={"pretty","html:target/html-output.html"}	
		)

public class TestRunner {

}
