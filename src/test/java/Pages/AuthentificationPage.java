package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Formation.Utils.BaseUtils;

public class AuthentificationPage extends BaseUtils {
	
	
	
	 public void Entrer_un_identifiant_valide() {
	    	
	    	WebElement identifiant=driver.findElement(By.xpath("//input[@placeholder='Identifiant']"));
	    	identifiant.sendKeys(props.getProperty("Identifiant"));
	    	//identifiant.sendKeys("AZOUZI@HUBONE.FR");
	   
	    }
	 
	 public void entrer_un_mot_de_passe_valide() {
	        driver.findElement(By.xpath("//input[@placeholder='Mot de passe']")).sendKeys("jynxUKGO8055!&#(");
	        
	    }
	 
	 public void valider_les_informations_et_cliquer_sur_le_bouton_de_connexion() {
		   WebElement Checkcondition=driver.findElement(By.cssSelector("input[type='checkbox']"));
		   Checkcondition.click();
		   System.out.println(Checkcondition.isSelected());
		   WebElement seconnecter=driver.findElement(By.xpath("//button[normalize-space()='Se connecter']"));
		   seconnecter.click();
	 }
	 
	
	 public void connexion_avec_succès_et_redirection_sur_linterface_gestion_des_utilisateurs() throws InterruptedException {
		 
	            Thread.sleep(2000);
	       
		 WebElement successMessage = driver.findElement(By.className("ant-notification"));

	        
	        if (successMessage.isDisplayed()) {
	            System.out.println("Notification de succès détectée : " + successMessage.getText());
	        } else {
	            System.out.println("Aucune notification de succès détectée");
	        }
	 }
}
