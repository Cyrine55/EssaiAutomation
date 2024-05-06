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
String siteType="Centre de distribution";


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
	
	public void le_bouton_Suivant_doit_etre_desactive_apres_vidage_du_champ() {
		WebElement Nomsite=driver.findElement(By.xpath("//input[@placeholder='Nom du site']"));
		Nomsite.clear();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Attendre jusqu'à 10 secondes au maximum
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Suivant']")));
	    WebElement suivantBtn = driver.findElement(By.xpath("//button[normalize-space()='Suivant']"));
	    assertTrue("Le bouton doit être désactivé après le vidage du champ", suivantBtn.isEnabled());
	}
	
	
	public void cliquer_sur_le_bouton_annuler() {
	    WebElement AnnulerBtn=driver.findElement(By.xpath("//button[normalize-space()='Annuler']"));
	    AnnulerBtn.click();
	}
	
	public void Valider_par_clique_sur_oui() {
		WebElement OuiBtn=driver.findElement(By.xpath("//span[normalize-space()='Oui']"));
		OuiBtn.click();
	}
	
	public void popup_du_modification_doit_etre_ferme() {
	    WebElement Sites=driver.findElement(By.xpath("//h2[contains(text(),'Sites')]"));
	    if(Sites.isDisplayed()) {
	    	System.out.println("popup est fermée"); }
	    	else 
	    		System.out.println("annulation echec");}
	 
	public void Selectionner_un_type() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement TypeSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nz-select-search[contains(@class, 'ant-select-selection-search')]")));
		TypeSearch.click();
		Thread.sleep(1000);
		//String xpathcentredistribution= "//div[@class='ant-select-item-option-content'][normalize-space()='Centre de distribution']";		
		//String xpathcentredistribution = "//div[@class='ant-select-item-option-content'][normalize-space()='" + SiteType + "']";
		String xpathcentredistribution = String.format("//div[@class='ant-select-item-option-content'][normalize-space()='%s']", siteType);
		WebElement SiteType=driver.findElement(By.xpath(xpathcentredistribution));
		//WebElement SiteType=driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Centre de distribution']"));
		SiteType.click();
	}
	
	
	
	
	}
	

