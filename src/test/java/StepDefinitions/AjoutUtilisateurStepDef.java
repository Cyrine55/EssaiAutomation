package StepDefinitions;

import Formation.Utils.BaseUtils;
import Pages.AjoutUtilisateurPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjoutUtilisateurStepDef extends  BaseUtils{
AjoutUtilisateurPage Ajoutpage=new AjoutUtilisateurPage();
String role = "Responsable";
String Sitename="site2";

	@Given("Utilisateur authentifié et dans la page gestion utilisateur")
	public void utilisateur_authentifié_et_dans_la_page_gestion_utilisateur() {
	}
	
	@When("Cliquer sur le bouton Ajouter")
	public void cliquer_sur_le_bouton_ajouter() {
		Ajoutpage.cliquer_sur_le_bouton_ajouter();
	}
	
	
	@When("Saisir Prenom et identifiant")
	public void saisir_prenom_et_identifiant() {
		Ajoutpage.saisir_prenom_et_identifiant();
}
	
	@When("Choisir un role")
	public void choisir_un_role() throws InterruptedException {
		Ajoutpage.choisir_un_role(role);
	}

	@When("Saisir une adresse mail valide")
	public void saisir_une_adresse_mail_valide() {
	   Ajoutpage.saisir_une_adresse_mail_valide(); 
	}
	
	@When("Generer un mot de passe")
	public void generer_un_mot_de_passe() {
	Ajoutpage.generer_un_mot_de_passe();   
	}
	
	@When("Choisiir un site")
	public void choisiir_un_site() throws InterruptedException {
	  Ajoutpage.choisiir_un_site(Sitename);  
	}
 
	@When("Cliquer sur Enregistrer")
	public void cliquer_sur_enregistrer() {
	 Ajoutpage.cliquer_sur_enregistrer();   
	}
	
	@Then("Utilisateur ajoute avec succes")
	public void utilisateur_ajoute_avec_succes() {
	   Ajoutpage.utilisateur_ajoute_avec_succes();
	}
	
	
	
	@When("j ajoute l utilisateur suivant")
	public void j_ajoute_l_utilisateur_suivant(DataTable userdata) throws InterruptedException {
			Ajoutpage.j_ajoute_l_utilisateur_suivant(userdata);   
	}
	

@Then("je ferme le navigateur")
public void je_ferme_le_navigateur() {
	close();
}

	
	
	
	
	
	
	
	
	
	
	
}
