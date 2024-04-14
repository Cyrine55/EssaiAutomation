package Runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features", glue = "" , plugin={"pretty", "html:target/reports/report.html","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},tags=""
, dryRun=false ,publish=true //sert à publier le rapport avec un lien pour le partager, mise à part le fichier local crée. Mais noter bien c'est pour le rapport du cumcumber

//check mapping entre stepdef et la méthode associé , sans exécution 
)
public class TestRunner {
	
}