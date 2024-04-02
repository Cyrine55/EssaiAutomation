package Pages;



import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import Formation.Utils.BaseUtils;
import io.cucumber.datatable.DataTable;

public class AjoutSitePage extends BaseUtils {
	 
	
	
	public void liste_des_sites_affichees() {
		WebElement Gestionsite=driver.findElement(By.xpath("//span[normalize-space()='Gestion des sites']"));
		  Actions action=new Actions(driver);  
		  action.moveToElement(Gestionsite).click().perform();
	}
	public void cliquer_sur_Ajouter() {
		WebElement AjoutSite=driver.findElement(By.xpath("//button[normalize-space()='Ajouter']"));
		AjoutSite.click();
	}
	 
	public void remplir_informations_du_site(DataTable dataTable) throws InterruptedException {
		
	    WebElement IDsite=driver.findElement(By.xpath("//input[@placeholder='Id du site']"));
	    IDsite.sendKeys(dataTable.cell(1, 0));
	    WebElement Nomsite=driver.findElement(By.xpath("//input[@placeholder='Nom du site']"));
	    Nomsite.sendKeys(dataTable.cell(1, 1));
	   
	    WebElement dropdowntype=driver.findElement(By.id("type"));
	    dropdowntype.click();
	    String typename1=(dataTable.cell(1, 2));
	    List <WebElement> Optionssite=driver.findElements(By.tagName("nz-option-item")) ;
	    for (WebElement option: Optionssite) {
	    	if(option.getAttribute("title").equals(typename1)) {
	    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
				break;	
	    	}
	    }
	    
	    WebElement adresse=driver.findElement(By.xpath("//input[@placeholder='Adresse']"));
	    adresse.sendKeys(dataTable.cell(1, 3));
	    
	    WebElement postal=driver.findElement(By.xpath("//input[@placeholder='Code postal']"));
	    postal.sendKeys(dataTable.cell(1, 4));
	
	    
	    WebElement ville=driver.findElement(By.xpath("//input[@formcontrolname='ville']"));
	    ville.sendKeys(dataTable.cell(1, 5));
	 // WebDriverWait wait = new WebDriverWait(driver, 10);
	   // WebElement ville=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Ville']")));
	   
	 
	}

	public void cliquer_sur_suivant() {
		WebElement suivantbtn=driver.findElement(By.xpath("//button[normalize-space()='Suivant']"));
	    Boolean test=suivantbtn.isEnabled();
	    suivantbtn.click();
	}
	
	public void remplir_zone() {
	    WebElement webzone=driver.findElement(By.xpath("//input[@placeholder='Nom du zone']"));
	    webzone.sendKeys("zoneauto");
	}
	
	
	public void cocher_statut() {
	   WebElement statut=driver.findElement(By.xpath("//label[@class='ant-checkbox-wrapper ant-checkbox-group-item ng-star-inserted']"));
	   //driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
	   statut.click();
	}
	

	public void enregistrer() {
		WebElement enregistrersite=driver.findElement(By.xpath("//button[@type='submit']"));
		enregistrersite.click();
	}
	
	
	public void site_enregistre() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		assertTrue("Le site ajouté n'est pas présent ", isSitePresentDansListe("Sitecyrine1"));
    }

  
    private boolean isSitePresentDansListe(String siteName) {
    	List<WebElement> siteElements = driver.findElements(By.xpath("//td[@class='ant-table-cell-fix-left-last ant-table-cell ant-table-cell-fix-left']"));
    	for (WebElement site : siteElements) {
    		 System.out.println(site.getText());
            if (site.getText().equals(siteName)) {
                return true;
            }
        }
    	 return false;
    }
	
	
	//AjoutSite Invalide 
    
    public void remplir_informations_invalides_du_site(DataTable dataTable) throws InterruptedException{
    	 WebElement IDsite=driver.findElement(By.xpath("//input[@placeholder='Id du site']"));
 	    IDsite.sendKeys(dataTable.cell(1, 0));
 	    WebElement Nomsite=driver.findElement(By.xpath("//input[@placeholder='Nom du site']"));
 	    Nomsite.sendKeys(dataTable.cell(1, 1));
 	   
 	    WebElement dropdowntype=driver.findElement(By.id("type"));
 	    dropdowntype.click();
 	    String typename1=(dataTable.cell(1, 2));
 	    List <WebElement> Optionssite=driver.findElements(By.tagName("nz-option-item")) ;
 	    for (WebElement option: Optionssite) {
 	    	if(option.getAttribute("title").equals(typename1)) {
 	    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
 				break;	
 	    	}
 	    }
 	    
 	    WebElement adresse=driver.findElement(By.xpath("//input[@placeholder='Adresse']"));
 	    adresse.sendKeys(dataTable.cell(1, 3));
 	    
 	    WebElement postal=driver.findElement(By.xpath("//input[@placeholder='Code postal']"));
 	    postal.sendKeys(dataTable.cell(1, 4));
 	
 	    
 	    WebElement ville=driver.findElement(By.xpath("//input[@formcontrolname='ville']"));
 	    ville.sendKeys(dataTable.cell(1, 5));
 	   }
	
    public void messages_erreurs_affiches() {
      //message erreru pour ID 
       WebElement erreurId=driver.findElement(By.xpath("(//div[contains(@role,'alert') and contains(text(),'Erreur de saisir id')])[1]"));	
       assertTrue(erreurId.isDisplayed());
       String msg="ID"+erreurId.getText();
       System.out.print(msg); // c'est correcte le msg est  bien affiché dans notre cas de test
    
  //message erreru pour nom
      WebElement erreurNom=driver.findElement(By.xpath("(//div[contains(@role,'alert') and contains(text(),'Erreur saisie nom')])"));	
      assertTrue(erreurNom.isDisplayed());
    
      String MessageNom="nom"+erreurNom.getText(); 
      System.out.print(MessageNom);
      WebElement postal=driver.findElement(By.xpath("(//div[contains(@role,'alert') and contains(text(),'Erreur saisie code postal')])"));
      assertTrue(postal.isDisplayed());
      String MessagePastal="Postal"+erreurNom.getText();
      System.out.print(MessagePastal);  }
    
    
    public void SuivantBtndisable() {
    	WebElement suivantbtn=driver.findElement(By.xpath("//button[normalize-space()='Suivant']"));	
    assertFalse(suivantbtn.isEnabled())	;
    }
    
    
   
                                                      /*Scénario du recherche Site Par ID . 		*/
    
    public void saisir_caracteres_id_dans_la_zone_de_recherche() throws InterruptedException {
        WebElement champrecherche=driver.findElement(By.xpath("//input[@placeholder='Rechercher par Nom et par id du site']"));
        Thread.sleep(2000);
        champrecherche.sendKeys("Sit");
    }
    
    public void site_relatif_au_id_affiche() {
     List<WebElement> listeIDelements=driver.findElements(By.cssSelector("tbody td:nth-child(2)"));
     List<String>listeID=new ArrayList<String>();
     for(WebElement listeIDelement:listeIDelements) {
    	 listeID.add(listeIDelement.getText()); }
     String caracteresSaisis = "Sit"; 
     for (String id : listeID) {
         assert id.contains(caracteresSaisis) : "L'identifiant ne correspond pas aux caractères saisis";
     }

     // Afficher les identifiants dans la console
     System.out.println("Liste des sites affichés :");
     for (String id : listeID) {
         System.out.println(id);
     }
 }
    
    public void saisir_caracteres_id_nexiste_pas(String IDinvalide) throws InterruptedException {
    	WebElement champrecherche=driver.findElement(By.xpath("//input[@placeholder='Rechercher par Nom et par id du site']"));
        Thread.sleep(2000);
        champrecherche.sendKeys(IDinvalide); 
    }
    
    public void liste_vide_avec_message_aucune_donnee() {
    	  WebElement aucunmsg=driver.findElement(By.xpath("//p[@class='ant-empty-description ng-star-inserted']"));
    	  //aucunmsg.isDisplayed();
    	  assertTrue(aucunmsg.isDisplayed())	;
    }
}