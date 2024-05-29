package Pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import Formation.Utils.BaseUtils;
import io.cucumber.datatable.DataTable;


public class ModifierSitePage extends BaseUtils {

int index=8;
String siteType="Restaurant";

public ModifierSitePage() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@type='checkbox']")
List<WebElement> CheckSiteList;

@FindBy(xpath="//tbody/tr[3]/td[7]/em[1]")
WebElement crayonmodif;

@FindBy(xpath="//input[@placeholder='Id du site']")
WebElement IDSite;

@FindBy(xpath="//input[@placeholder='Nom du site']")
WebElement NameSite;

@FindBy(xpath="//button[@type='button'][normalize-space()='Ajouter']")
WebElement btnajouter;

@FindBy(xpath="//button[normalize-space()='Suivant']")
WebElement suivantBtn;

@FindBy(xpath="//input[@placeholder='Nom du zone']")
List<WebElement> Zones;

@FindBy(xpath="//app-add-site/div")
List<WebElement> Blocs;

@FindBy(xpath="//input[@placeholder='Nom du site']")
WebElement Nomsite;

@FindBy(xpath="//button[normalize-space()='Annuler']")
WebElement AnnulerBtn;

@FindBy(xpath="//span[normalize-space()='Oui']")
WebElement OuiBtn;

@FindBy(xpath="//h2[contains(text(),'Sites')]")
WebElement Sites;

@FindBy(id="city")
WebElement VilleInput;

@FindBy(xpath="//button[normalize-space()='Valider']")
WebElement ValiderBtnFiltre;

@FindBy(xpath="//nz-select-search[contains(@class, 'ant-select-selection-search')]")
WebElement TypeSearch;
public void selectionner_un_sitee() {
   
		// Sélectionner un checkbox avec un index que nous l'identifié 
		if (index >= 0 && index < CheckSiteList.size()) {
	        CheckSiteList.get(index).click();
	    } else {
	        System.out.println("Index hors limites.");
	    }
		
	}
	public void cliquer_sur_crayon_modifier() throws InterruptedException {

	   crayonmodif.click();
	   Thread.sleep(1000);   
	}

	public void popup_affichee_avec_champ_id_et_type_desactivee() {
	    assertTrue("Le champ n'est pas désactivé", IDSite.isEnabled());
	}
	
	public void saisir_les_informations_suivantes(DataTable dataTable) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    NameSite.clear();
        NameSite.sendKeys(dataTable.cell(1, 0));
       
	}
	
	public void saisir_nouveau_nom_du_zone_et_un_nouveau_statut() {
		 btnajouter.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement textzone = Zones.get(1);
		 textzone.click();
		 textzone.sendKeys("cyhcy");
		 
		//Ici on  va mettre les bloc dans une liste w on a mis size-1, car le dernier bloc c'est pour les boutons donc on va pas faire la recherche dans ce bloc
		 
		int nbre_site = Blocs.size()-1;
		
		//Préparation d'un xpath dynamique pou un type de site
	    String Xpath_miseaurebut = "//app-add-site/div["+nbre_site+"]/div[2]/nz-checkbox-group/label[2]/span[1]/input";
        driver.findElement(By.xpath(Xpath_miseaurebut)).click();
}
	
	public void le_bouton_Suivant_doit_etre_desactive_apres_vidage_du_champ() {
		Nomsite.clear();
	    assertTrue("Le bouton doit être désactivé après le vidage du champ", suivantBtn.isEnabled());
	}
	
	
	public void cliquer_sur_le_bouton_annuler() {
	    AnnulerBtn.click();
	}
	
	public void Valider_par_clique_sur_oui() {
		OuiBtn.click();
	}
	
	public void popup_du_modification_doit_etre_ferme() {
	    if(Sites.isDisplayed()) {
	    	System.out.println("popup est fermée"); }
	    	else 
	    		System.out.println("annulation echec");}
	 
	public void Selectionner_un_type() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		wait.until(ExpectedConditions.visibilityOf(TypeSearch));
		TypeSearch.click();
		Thread.sleep(3000);
		String xpathType = String.format("//div[@class='ant-select-item-option-content'][normalize-space()='%s']", siteType);
		WebElement SiteType=driver.findElement(By.xpath(xpathType));
		SiteType.click();
	}
	
	public void saisir_une_ville() {
	
	 VilleInput.sendKeys("Beauvais");
	}
	
	
	public void cliquer_sur_le_bouton_valider() {
	 
	   ValiderBtnFiltre.click();
	}
	
	public void resultat_correspondante_affichee() {
      String TypeChoisi = driver.findElement(By.xpath("//nz-select-item")).getText();
	  System.out.println(TypeChoisi);
	  String VilleChoisi=driver.findElement(By.id("city")).getAttribute("value");
	  System.out.println("la ville est : "+VilleChoisi);
	  
	  //localisation du nom du ville dans le tableau
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  String VilleFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/app-simple-table/div/div/nz-table/nz-spin/div/div/nz-table-inner-scroll/div[2]/table/tbody/tr[2]/td[3]"))).getText();
	  System.out.println("text dans le tableau est " +VilleFinal);
	  
	  //localisation du nom du type dans le tableau
	  String TypeFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nz-table-inner-scroll/div[2]/table/tbody/tr[2]/td[5]"))).getText();
	  System.out.println("text dans le tableau est " +TypeFinal);
	  
	  assertTrue("ville pas confrome" ,TypeChoisi.equals(TypeFinal)); }
	
		}
	

