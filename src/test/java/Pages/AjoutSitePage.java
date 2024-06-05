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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.openqa.selenium.support.ui.WebDriverWait;

import Formation.Utils.BaseUtils;
import io.cucumber.datatable.DataTable;

public class AjoutSitePage extends BaseUtils {
	
	 public AjoutSitePage() {
		PageFactory.initElements(driver, this);
	 }
	
	 @FindBy(xpath="//span[normalize-space()='Gestion des sites']")
	 WebElement Gestionsite;
	 @FindBy(xpath="//button[normalize-space()='Ajouter']")
	 WebElement AjoutSite;
	 @FindBy(xpath="//input[@placeholder='Id du site']")
	 WebElement IDsite;
	 @FindBy(xpath="//input[@placeholder='Nom du site']")
	 WebElement Nomsite;
	 @FindBy(id="type")
	 WebElement dropdowntype;
	 
	 @FindBy(tagName="nz-option-item")
	 List<WebElement> Optionssite;
	 @FindBy(xpath="//input[@placeholder='Adresse']")
	 WebElement adresse;
	 @FindBy(xpath="//input[@placeholder='Code postal']")
	 WebElement postal;
	 @FindBy(xpath="//input[@formcontrolname='ville']")
	 WebElement ville;
	 @FindBy(xpath="//button[normalize-space()='Suivant']")
	 WebElement suivantbtn;
	 
	 @FindBy(xpath="//input[@placeholder='Nom du zone']")
	 WebElement webzone; 
	 @FindBy(xpath="//label[@class='ant-checkbox-wrapper ant-checkbox-group-item ng-star-inserted']")
	 WebElement statut;
	 @FindBy(xpath="//button[@type='submit']")
	 WebElement enregistrersite;
	 
	 
	 @FindBy(xpath="//td[@class='ant-table-cell-fix-left-last ant-table-cell ant-table-cell-fix-left']")
	 List<WebElement> siteElements;
	 
	 
	 
	 //erreur 
	 @FindBy(xpath="(//div[contains(@role,'alert') and contains(text(),'Erreur de saisir id')])[1]")
	WebElement erreurId;
	 @FindBy(xpath="(//div[contains(@role,'alert') and contains(text(),'Erreur saisie nom')])")
	WebElement erreurNom;
	 @FindBy(xpath="(//div[contains(@role,'alert') and contains(text(),'Erreur saisie code postal')])")
	WebElement postal1;
	 
	 //Ajout par export
	 @FindBy(xpath="//div/span/button[2]")
	 WebElement ImporterBtn;
	 @FindBy(xpath="//nz-modal-container/div/div/div[2]/import-add/div/div[1]/div[2]/label/span[2]")
	 WebElement Parcourir;	 
	 @FindBy(id="file-upload")
	 WebElement inputfile;
	 @FindBy(xpath="//button[@type='submit']")
	 WebElement Importer;
	// @FindBy(xpath="//div[@class='alert alert-error']")
	 @FindBy(xpath="//div[@class='alert alert-error' and contains(text(),' Fichier en erreur ')]")
	 WebElement MsgErreur;
	
	public void liste_des_sites_affichees() throws InterruptedException {
		Thread.sleep(4000);		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		//WebElement Gestionsite=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Gestion des sites']")));  
		Actions action=new Actions(driver);  
		  action.moveToElement(Gestionsite).click().perform();
	}
	public void cliquer_sur_Ajouter() {
		AjoutSite.click();
	}
	 
	public void remplir_informations_du_site(DataTable dataTable) throws InterruptedException {
	
	    IDsite.sendKeys(dataTable.cell(1, 0));
	    Nomsite.sendKeys(dataTable.cell(1, 1));
	    dropdowntype.click();
	    
	    String typename1=(dataTable.cell(1, 2));
	    for (WebElement option: Optionssite) {
	    	if(option.getAttribute("title").equals(typename1)) {
	    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
				break;	
	    	}
	    }
	   
	    adresse.sendKeys(dataTable.cell(1, 3));
	    postal.sendKeys(dataTable.cell(1, 4));
	    ville.sendKeys(dataTable.cell(1, 5));
	    
	}

	public void cliquer_sur_suivant() {
		
	    Boolean test=suivantbtn.isEnabled();
	    suivantbtn.click();
	}
	
	public void remplir_zone() {
	
	    webzone.sendKeys("zoneauto");
	}
	
	
	public void cocher_statut() {

	   statut.click();
	}

	public void enregistrer() {
		
		enregistrersite.click();
	}
	
	public void site_enregistre() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		assertTrue("Le site ajouté n'est pas présent ", isSitePresentDansListe("Sitecyrine1"));
    }

  
    private boolean isSitePresentDansListe(String siteName) {
   
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
  
 	    IDsite.sendKeys(dataTable.cell(1, 0));
 	    Nomsite.sendKeys(dataTable.cell(1, 1));
 	    dropdowntype.click();
 	    String typename1=(dataTable.cell(1, 2));
 	 
 	    for (WebElement option: Optionssite) {
 	    	if(option.getAttribute("title").equals(typename1)) {
 	    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
 				break;	
 	    	}
 	    }
 	    
 	    adresse.sendKeys(dataTable.cell(1, 3));
 	    postal.sendKeys(dataTable.cell(1, 4));
 	    ville.sendKeys(dataTable.cell(1, 5));
 	   }
	
    public void messages_erreurs_affiches() {
      
      	
       assertTrue(erreurId.isDisplayed());
       String msg="ID"+erreurId.getText();
       System.out.print(msg); // c'est correcte le msg est  bien affiché dans notre cas de test
 
      assertTrue(erreurNom.isDisplayed());
    
      String MessageNom="nom"+erreurNom.getText(); 
      System.out.print(MessageNom);
      assertTrue(postal1.isDisplayed());
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
    
    //Section Ajout site avec import fichier json erroné 
    public void cliquer_sur_le_bouton_importer() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(ImporterBtn));
        ImporterBtn.click();
    }
    
    public void cliquer_sur_le_bouton_parcourir_et_selectionner_un_fichier() {
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(Parcourir));
        inputfile.sendKeys("C:\\Users\\Cyrine\\Desktop\\importsite.json");   
      }
    
    public void cliquer_sur_importer() {
    	Importer.click();
    }
    
    public void message_erreur_affiche() {
    	assertTrue(MsgErreur.isDisplayed());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}