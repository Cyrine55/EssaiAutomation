package StepDefinitions;

import org.junit.Test;

import Formation.Utils.BaseUtils;
import Pages.AjoutSitePage;
import Pages.SupprimerSitePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SupprimerSiteStepDef extends  BaseUtils {
	SupprimerSitePage Supprimersite=new SupprimerSitePage();
	//AjoutSitePage Sitepage=new AjoutSitePage();
	
	
int index=4;
String message="Êtes-vous sûr de bien vouloir supprimer ce / ces site(s)?";
	/*@When("Selectionner un site")
	public void selectionner_un_site() {
		Supprimersite.selectionner_un_site(index);
	}*/

	@And("Cliquer sur le bouton Supprimer")
	public void cliquer_sur_le_bouton_supprimer() {
		Supprimersite.cliquer_sur_le_bouton_supprimer();
	}
	
	@And("le message de suppression est affiche {string}")
		
	public void le_message_de_suppression_est_affiche(String Msg_suppression) {
		Supprimersite.le_message_de_suppression_est_affiche(Msg_suppression);	
	
	}
	
	@And("Cliquer sur oui")
	public void cliquer_sur_oui() {
	    Supprimersite.cliquer_sur_oui();
	}
	
	@Then("Site supprime avec un message succes")
	public void site_supprime_avec_un_message_succes() throws InterruptedException {
	   Supprimersite.site_supprime_avec_un_message_succes();
	}
	
}
