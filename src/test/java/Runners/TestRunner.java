package Runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features/AjoutUtilisateurX.feature", glue = "" , plugin={"pretty", "html:target/reports/report.html"}, tags="")
public class TestRunner {
	
	
	

}