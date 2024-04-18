package Pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import Formation.Utils.BaseUtils;
import io.cucumber.datatable.DataTable;

public class ModifierSitePage extends BaseUtils {

int index=9;


	public void cliquer_sur_crayon_modifier() throws InterruptedException {
		
	   WebElement crayonmodif=driver.findElement(By.xpath("//tbody/tr[7]/td[7]/em[1]"));
	   crayonmodif.click();
	   Thread.sleep(1000);
	    
	}
	
	public void selectionner_un_sitee() {
      List<WebElement> CheckSiteList=driver.findElements(By.xpath("//input[@type='checkbox']"));
		// Sélectionner un checkbox avec un index que nous l'identifié 
		if (index >= 0 && index < CheckSiteList.size()) {
	        CheckSiteList.get(index).click();
	    } else {
	        System.out.println("Index hors limites.");
	    }
		
	}
	
	public void popup_affichee_avec_champ_id_et_type_desactivee() {
	    WebElement IDSite=driver.findElement(By.xpath("//input[@placeholder='Id du site']"));
	    assertTrue("Le champ n'est pas désactivé", IDSite.isEnabled());
	}
	
	public void saisir_les_informations_suivantes(DataTable dataTable) {
		
		//WebElement NameSite=driver.findElement(By.xpath("//input[contains(text(),'Nom du site')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement NameSite=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Nom du site']"))); 
	    NameSite.clear();
        NameSite.sendKeys(dataTable.cell(1, 0));
       
	}
	
	public void saisir_nouveau_nom_du_zone_et_un_nouveau_statut() throws InterruptedException  {

		/*WebElement statut2 = driver.findElement(By.xpath("//label[5]//span[1]//input[1]"));
		 statut2.click();*/
		 
		 WebElement btnajouter=driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Ajouter']"));
		 btnajouter.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Thread.sleep(1000);
		//WebElement statut3 = driver.findElement(By.xpath("//*[contains(@class, 'ant-checkbox-input')][8]"));
		//WebElement statut3 = driver.findElement(By.xpath("//span[@class='ant-checkbox'][8]"));
		//WebElement statut3 = driver.findElement(By.xpath("//input[@type='checkbox'][8]"));
		List<WebElement> Zones = driver.findElements(By.xpath("//input[@placeholder='Nom du zone']"));
		WebElement textzone = Zones.get(1);
		textzone.click();
		//WebElement textzone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Nom du zone'][2]"))); 
		
		 textzone.sendKeys("cyhcy");
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='ant-checkbox']"));
		WebElement statut3 = elements.get(14);
		 statut3.click();
		 
		 Thread.sleep(500);
		 
	}
	
	

	
	
	
	
	
	
}
