package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Formation.Utils.BaseUtils;

public class Stock_ExpeditionPage extends BaseUtils {
	
	public Stock_ExpeditionPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Gestion de stock')]")
	WebElement GestionStockBtn;
	
	@FindBy(xpath="//div[2]/ul/li[1]/span")
	WebElement ExpeditionBtn;
	
	
	@FindBy(xpath="//nz-range-picker/div[1]/input")
	WebElement debut;

	@FindBy(xpath="//nz-range-picker/div[3]/input")
	WebElement fin;
	
	String dateDebut = "18/05/2024";
    String dateFin="01/06/2024";
	
	
	public void ecran_expéditions_affiche() {
	 GestionStockBtn.click();
	 ExpeditionBtn.click(); 
	  }
	
	public void choisir_un_interval_de_date_depuis_calendrier() throws InterruptedException  {
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    wait.until(ExpectedConditions.elementToBeClickable(debut));
	   debut.click();
        js.executeScript("arguments[0].value=arguments[1];", debut, dateDebut);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", debut);
     // Faire perdre le focus au champ de début pour déclencher les mises à jour nécessaires
        js.executeScript("arguments[0].dispatchEvent(new Event('blur'));", debut);
        js.executeScript("document.activeElement.blur();");
	      wait.until(ExpectedConditions.visibilityOf(fin));
	      js.executeScript("arguments[0].value=arguments[1];", fin, dateFin);
		  js.executeScript("arguments[0].dispatchEvent(new Event('change'));", fin);
		  js.executeScript("arguments[0].dispatchEvent(new Event('blur'));", fin);
		  js.executeScript("document.activeElement.blur();");
		  
		  	   
	}
	
	

	          
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
