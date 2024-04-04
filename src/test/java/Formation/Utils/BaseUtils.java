package Formation.Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class BaseUtils {
public static WebDriver driver;
//String url = "https://hogt-rec.mobility.hubone.cloud/login";
public static Properties props=new Properties();

public BaseUtils() {
	try {
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		props.load(file);}
	catch(FileNotFoundException e) {
		e.printStackTrace();}
	catch(IOException e) {
		e.printStackTrace();
		
	  }
     }

public void initializeDriver() {
	
	
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(props.getProperty("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
@After
public void close() {
	driver.quit();
}

/*@AfterStep
public static void Screen(Scenario scenario) {
	// this is for cucumber junit report
	Utilities.ScreenExp1(scenario, driver);
	}*/
}
	

