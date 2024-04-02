package StepDefinitions;
import Formation.Utils.BaseUtils;
import Pages.AuthentificationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthentificationStepDef extends  BaseUtils {
	AuthentificationPage Auth = new AuthentificationPage(); /*creation objet de la classe Authentification page pour 
	                                                          pouvoir faire appeler les méthodes */
	
	@Given("Utilisateur ouvre la page de connexion")
	public void utilisateur_ouvre_la_page_de_connexion() {
	
	}
	
	@When("Entrer un identifiant valide")
	public void entrer_un_identifiant_valide() {
		Auth.Entrer_un_identifiant_valide();
	}
   
	  @When("Entrer un mot de passe valide")
   public void entrer_un_mot_de_passe_valide(){
		  Auth.entrer_un_mot_de_passe_valide();
	  }
	  
	  @When("Valider les informations et cliquer sur le bouton de connexion")
	  public void valider_les_informations_et_cliquer_sur_le_bouton_de_connexion() {
	      Auth.valider_les_informations_et_cliquer_sur_le_bouton_de_connexion();
	  }
	  @Then("Connexion avec succès et redirection sur linterface Gestion des utilisateurs")
	  public void connexion_avec_succès_et_redirection_sur_linterface_gestion_des_utilisateurs() throws InterruptedException {
	      Auth.connexion_avec_succès_et_redirection_sur_linterface_gestion_des_utilisateurs();
	  }
}
