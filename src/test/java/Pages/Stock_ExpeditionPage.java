package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Formation.Utils.BaseUtils;

public class Stock_ExpeditionPage extends BaseUtils {
	
	
	public void ecran_expéditions_affiche() {
	 WebElement GestionStockBtn= driver.findElement(By.xpath("//span[contains(text(),'Gestion de stock')]"));
	 GestionStockBtn.click();
	 WebElement ExpeditionBtn=driver.findElement(By.xpath("//div[2]/ul/li[1]/span"));
	 ExpeditionBtn.click(); 
	  }
	
	public void choisir_un_interval_de_date_depuis_calendrier() throws InterruptedException {
	   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	      WebElement Datedebut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/app-root/app-layout/nz-layout/nz-layout/nz-layout/nz-content/app-list-shipments/header/div[2]/nz-range-picker/div[1]/input")));
	      Datedebut.click();
	      WebElement debut=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nz-range-picker/div[1]/input")));
	   
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      String dateDebut = "30/05/2024";
	       String dateFin="01/06/2024";
	  
	       js.executeScript("arguments[0].value=arguments[1];", debut, dateDebut);
	       js.executeScript("arguments[0].dispatchEvent(new Event('change'));", debut);
	       Thread.sleep(3000);
	       js.executeScript("document.querySelector('body').click();");//pour fermer le 1er calendrier
	       Thread.sleep(3000);
	       WebElement DateFin = driver.findElement(By.xpath("//input[@placeholder='Date de fin']"));
	       DateFin.click();
	       WebElement fin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nz-range-picker/div[3]/input")));
		   js.executeScript("arguments[0].value=arguments[1];", fin, dateFin);
		   js.executeScript("arguments[0].dispatchEvent(new Event('change'));", fin);
		    Thread.sleep(1000); 
	}
	
	

	          
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
