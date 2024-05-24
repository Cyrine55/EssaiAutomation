package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Formation.Utils.BaseUtils;

public class AuthentificationPage extends BaseUtils {
	
	public AuthentificationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Identifiant']")
	WebElement identifiant;
	@FindBy(css="input[type='checkbox']")
	WebElement Checkcondition;
	@FindBy(xpath="//button[normalize-space()='Se connecter']")
	WebElement seconnecter;
	@FindBy(className="ant-notification")
	WebElement successMessage;
	
	
	 public void Entrer_un_identifiant_valide() {
	    	identifiant.sendKeys(props.getProperty("Identifiant"));
	   
	    }
	 
	 public void entrer_un_mot_de_passe_valide() {
	        driver.findElement(By.xpath("//input[@placeholder='Mot de passe']")).sendKeys("jynxUKGO8055!&#(");
	         }
	 
	 public void valider_les_informations_et_cliquer_sur_le_bouton_de_connexion() {
		   Checkcondition.click();
		   System.out.println(Checkcondition.isSelected());
		   seconnecter.click();
	 }
	 
	
	 public void connexion_avec_succès_et_redirection_sur_linterface_gestion_des_utilisateurs() throws InterruptedException {
		 
	            Thread.sleep(2000);
	        if (successMessage.isDisplayed()) {
	            System.out.println("Notification de succès détectée : " + successMessage.getText());
	        } else {
	            System.out.println("Aucune notification de succès détectée");
	        }
	 }
}
