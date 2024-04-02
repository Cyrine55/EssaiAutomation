package StepDefinitions;

import Formation.Utils.BaseUtils;
import Pages.AjoutSitePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjoutSiteStepDef extends  BaseUtils{
AjoutSitePage Sitepage=new AjoutSitePage();
String IDinvalide="ùùù";
@Given("Liste des sites affichees")
public void liste_des_sites_affichees() {
	Sitepage.liste_des_sites_affichees();
}


@When("cliquer sur Ajouter")
public void cliquer_sur_Ajouter() {
Sitepage.cliquer_sur_Ajouter();	
}
@When("Remplir informations du site")
public void remplir_informations_du_site(DataTable dataTable) throws InterruptedException {
	Sitepage.remplir_informations_du_site( dataTable);
}

@When("Cliquer sur Suivant")
public void cliquer_sur_suivant() {
	Sitepage.cliquer_sur_suivant();  
}

@When("Remplir Zone")
public void remplir_zone() {
    Sitepage.remplir_zone();
}

@When("Cocher Statut")
public void cocher_statut() {
	Sitepage.cocher_statut();  
}

@When("Enregistrer")
public void enregistrer() {
	Sitepage.enregistrer();
}

@Then("Site enregistre") 
public void site_enregistre() {
	Sitepage.site_enregistre();
	
}
@When("Remplir informations invalides du site")
public void remplir_informations_invalides_du_site(DataTable dataTable) throws InterruptedException {
	Sitepage.remplir_informations_invalides_du_site(dataTable);
}

@Then("Messages erreurs affiches")
public void messages_erreurs_affiches() {
	Sitepage.messages_erreurs_affiches();
	Sitepage.SuivantBtndisable();
}


@When("Saisir caracteres ID dans la zone de recherche")
public void saisir_caracteres_id_dans_la_zone_de_recherche() throws InterruptedException {
   Sitepage.saisir_caracteres_id_dans_la_zone_de_recherche();
}

@Then("Site relatif au ID affiche")
public void site_relatif_au_id_affiche() {
 Sitepage.site_relatif_au_id_affiche();
}


@When("Saisir caracteres ID nexiste pas")
public void saisir_caracteres_id_nexiste_pas() throws InterruptedException {
	Sitepage.saisir_caracteres_id_nexiste_pas(IDinvalide);
}

@Then("liste vide avec message aucune donnee")
public void liste_vide_avec_message_aucune_donnee() {
  Sitepage.liste_vide_avec_message_aucune_donnee();
}



















}



