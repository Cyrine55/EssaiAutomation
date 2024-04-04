/*package Formation.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Utilities extends BaseUtils{
	@After
	public static void ScreenExp1(Scenario scenario, WebDriver driver) {
		// this is for cucumber junit report
		if(scenario.isFailed()){
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());
		}
	}
}
*/