package Pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Formation.Utils.BaseUtils;
import io.cucumber.datatable.DataTable;


public class AjoutUtilisateurPage extends BaseUtils{

	
public void cliquer_sur_le_bouton_ajouter() {
       WebElement btnAjout=driver.findElement(By.xpath("//button[normalize-space()='Ajouter']"));
       btnAjout.click();
     }
public void saisir_prenom_et_identifiant() {
	WebElement prenom=driver.findElement(By.xpath("//input[@placeholder='Prénom']"));
	prenom.sendKeys("NomTest5");
	WebElement nom=driver.findElement(By.xpath("//input[@placeholder='Nom']"));
    nom.sendKeys("PrenomTest5");
    
    WebElement identifiant=driver.findElement(By.xpath("//input[@placeholder='Identifiant']"));
    identifiant.sendKeys("test1235");

}
     

 public void choisir_un_role(String role) throws InterruptedException {
	 
	Thread.sleep(2000);
	WebElement container = driver.findElement(By.xpath("//div[@role='document']"));
	 //WebElement role = container.findElement(By.xpath("//nz-select[@id='role']/descendant::input"));
	WebElement Role = container.findElement(By.id("role"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].click();", Role);
	 
	WebElement drop=driver.findElement(By.id("cdk-overlay-1"));
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 List<WebElement> options = driver.findElements(By.tagName("nz-option-item"));
	
	for(WebElement option:options) {
		System.out.println("affich"+option.getAttribute("title"));
		if(option.getAttribute("title").equals(role)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
			break;
		}
	}
	 /*Select dropdown = new Select(drop);
	 dropdown.selectByIndex(2);*/
	 
      }
 public void saisir_une_adresse_mail_valide() {
	 WebElement mail1=driver.findElement(By.xpath("//input[@placeholder='hubone.fr']"));
	 mail1.sendKeys("hubone.fr");  
	}
 

	public void generer_un_mot_de_passe() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement MdpButton=driver.findElement(By.xpath("//button[@type='button']"));
		MdpButton.click();
	    WebElement mdp=driver.findElement(By.xpath("//input[@formcontrolname='password']"));
	    System.out.println("le mdpd generé est:"+mdp.getAttribute("value"));
	}
 
 
 public void choisiir_un_site(String Sitename) throws InterruptedException {
	 WebElement site=driver.findElement(By.id("sites")) ;
	  site.click();
	  
	  List<WebElement> sitesoptions=driver.findElements(By.tagName("nz-option-item"));
	  for(WebElement option:sitesoptions) {
			if(option.getAttribute("title").equals(Sitename)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
				break;
			}
		}
	}
 public void cliquer_sur_enregistrer() {
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 //driver.quit();
	}
 
 public void j_ajoute_l_utilisateur_suivant(DataTable userdata) throws InterruptedException {
	 WebElement prenom=driver.findElement(By.xpath("//input[@placeholder='Prénom']"));
		prenom.sendKeys(userdata.cell(1, 0));
		WebElement nom=driver.findElement(By.xpath("//input[@placeholder='Nom']"));
	    nom.sendKeys(userdata.cell(1, 1));
	    WebElement identifiant=driver.findElement(By.xpath("//input[@placeholder='Identifiant']"));
	    identifiant.sendKeys(userdata.cell(1, 2));
	    WebElement mail1=driver.findElement(By.xpath("//input[@placeholder='hubone.fr']"));
		 mail1.sendKeys(userdata.cell(1, 3));
		 String role = userdata.cell(1, 4);
		 choisir_un_role(role);
		 String Sitename=userdata.cell(1, 5);
		 choisiir_un_site(Sitename);
 }

 
 public void utilisateur_ajoute_avec_succes() {
	   //WebElement titre=driver.findElement(By.className("title ng-star-inserted"));
	   //assertTrue(titre.isDisplayed());
	}
 
 
 
 
 
 
 
 
}
