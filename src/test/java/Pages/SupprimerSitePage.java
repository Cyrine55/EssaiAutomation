package Pages;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Formation.Utils.BaseUtils;

public class SupprimerSitePage extends BaseUtils {
	
	/*public void selectionner_un_site(int index) {
	    
		List<WebElement> CheckSiteList=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
	
		
		// Sélectionner un checkbox avec un index que nous l'identifié 
		if (index >= 0 && index < CheckSiteList.size()) {
	        CheckSiteList.get(index).click();
	    } else {
	        System.out.println("Index hors limites.");
	    }
		
		
		// Sélectionner tous les checkbox 
		//for(WebElement check: CheckSiteList ) {
		//	if (! check.isSelected()) {
			//	check.click();
				//break;
			//}
			
	//	}
		
	}*/
	
	public void cliquer_sur_le_bouton_supprimer() {
	    WebElement Btn_Supprimer=driver.findElement(By.xpath("//tbody/tr[6]/td[7]/em[2]"));
	    Btn_Supprimer.click();
	}
	
	public void le_message_de_suppression_est_affiche(String message) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement MsgElement= driver.findElement(By.xpath("//div[contains(text(),'Êtes-vous sûr de bien vouloir supprimer ce site?')]"));
		String Msg_suppression=MsgElement.getText().trim();
		System.out.println("Message de suppression souhaité : " + message);
		System.out.println("Message de suppression obtenue : " + Msg_suppression);
		//String msg=Msg_suppression.toString();
		assertEquals(Msg_suppression.toLowerCase(),message.toLowerCase());
	}

	
	public void cliquer_sur_oui() {
		WebElement container= driver.findElement(By.xpath("//div[@class='content-text']"));
		WebElement Btn_oui=container.findElement(By.xpath("//span[normalize-space()='Oui']"));
	   Btn_oui.click();
	}

	
	public void site_supprime_avec_un_message_succes() throws InterruptedException {
		Thread.sleep(2000);
	    //WebElement Success_alert=driver.findElement(By.className("ant-notification-notice-message ng-tns-c53-87"));
		
		WebElement Success_alert=new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-notification-notice-message")));
	    assertTrue(Success_alert.isDisplayed());
	}
	
	
	
	
	
	
	

}
