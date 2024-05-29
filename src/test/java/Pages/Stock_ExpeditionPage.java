package Pages;

import java.time.Duration;

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
	
	@FindBy(xpath="html/body/app-root/app-layout/nz-layout/nz-layout/nz-layout/nz-content/app-list-shipments/header/div[2]/nz-range-picker/div[1]/input")
	WebElement Datedebut;
	
	@FindBy(xpath="//nz-range-picker/div[1]/input")
	WebElement debut;
	@FindBy(xpath="//input[@placeholder='Date de fin']")
	WebElement DateFin;
	
	@FindBy(xpath="//nz-range-picker/div[3]/input")
	WebElement fin;
	
	String dateDebut = "21/05/2024";
    String dateFin="01/06/2024";
	
	
	public void ecran_expéditions_affiche() {
	 GestionStockBtn.click();
	 ExpeditionBtn.click(); 
	  }
	
	public void choisir_un_interval_de_date_depuis_calendrier() throws InterruptedException {
	   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.elementToBeClickable(Datedebut));
	    Datedebut.click();
	   wait.until(ExpectedConditions.visibilityOf(debut));
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      
	  
	       js.executeScript("arguments[0].value=arguments[1];", debut, dateDebut);
	       js.executeScript("arguments[0].dispatchEvent(new Event('change'));", debut);
	       Thread.sleep(3000);
	       js.executeScript("document.querySelector('body').click();");//pour fermer le 1er calendrier
	       Thread.sleep(2000);
	       DateFin.click();
	       wait.until(ExpectedConditions.visibilityOf(DateFin));
		   js.executeScript("arguments[0].value=arguments[1];", fin, dateFin);
		   js.executeScript("arguments[0].dispatchEvent(new Event('change'));", fin);
		    Thread.sleep(1000); 
	}
	
	

	          
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
