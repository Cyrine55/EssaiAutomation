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

int index=8;

public void selectionner_un_sitee() {
    List<WebElement> CheckSiteList=driver.findElements(By.xpath("//input[@type='checkbox']"));
		// Sélectionner un checkbox avec un index que nous l'identifié 
		if (index >= 0 && index < CheckSiteList.size()) {
	        CheckSiteList.get(index).click();
	    } else {
	        System.out.println("Index hors limites.");
	    }
		
	}
	public void cliquer_sur_crayon_modifier() throws InterruptedException {
		
	   WebElement crayonmodif=driver.findElement(By.xpath("//tbody/tr[3]/td[7]/em[1]"));
	   crayonmodif.click();
	   Thread.sleep(1000);
	    
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
	
	
	public void saisir_nouveau_nom_du_zone_et_un_nouveau_statut() {
		WebElement btnajouter=driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Ajouter']"));
		 btnajouter.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 List<WebElement> Zones = driver.findElements(By.xpath("//input[@placeholder='Nom du zone']"));
		 WebElement textzone = Zones.get(1);
		 textzone.click();
		 textzone.sendKeys("cyhcy");
		 
		//Ici on  va mettre les bloc dans une liste w on a mis size-1, car le dernier bloc c'est pour les boutons donc on va pas faire la recherche dans ce bloc
		List<WebElement> Blocs = driver.findElements(By.xpath("//app-add-site/div"));
		int nbre_site = Blocs.size()-1;
		
		//Préparation d'un xpath dynamique pou un type de site
		String Xpath_miseaurebut = "//app-add-site/div["+nbre_site+"]/div[2]/nz-checkbox-group/label[2]/span[1]/input";
        driver.findElement(By.xpath(Xpath_miseaurebut)).click();

		
	}

	
	
	
	
	
	
}
