package StepDefinitions;

import org.junit.Test;

import Formation.Utils.BaseUtils;
import Pages.ModifierSitePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModifierSiteStepDef extends  BaseUtils{
ModifierSitePage ModifSitePage=new ModifierSitePage();
@Test
@When("Selectionner un sitee")
public void selectionner_un_sitee() {
	ModifSitePage.selectionner_un_sitee();
}
@Test
@When("Cliquer sur crayon modifier")
public void cliquer_sur_crayon_modifier() throws InterruptedException {
	ModifSitePage.cliquer_sur_crayon_modifier();
}



@Test
@When("Popup affichee avec champ ID et type desactivee")
public void popup_affichee_avec_champ_id_et_type_desactivee() {
	ModifSitePage.popup_affichee_avec_champ_id_et_type_desactivee();
	
}

@Test
@When("Saisir les informations suivantes")
public void saisir_les_informations_suivantes(io.cucumber.datatable.DataTable dataTable)  {

	ModifSitePage.saisir_les_informations_suivantes(dataTable);

}

@Test
@When("Saisir nouveau nom du zone et un nouveau statut")
public void saisir_nouveau_nom_du_zone_et_un_nouveau_statut(){
	ModifSitePage.saisir_nouveau_nom_du_zone_et_un_nouveau_statut(); 
	
}


@Test
@Then("le bouton Suivant doit etre desactive apres vidage du champ")
public void le_bouton_Suivant_doit_etre_desactive_apres_vidage_du_champ() {
	ModifSitePage.le_bouton_Suivant_doit_etre_desactive_apres_vidage_du_champ();
}

@Test
@When("Cliquer sur le bouton Annuler")
public void cliquer_sur_le_bouton_annuler() {
	ModifSitePage.cliquer_sur_le_bouton_annuler();
}

@Test
@When("Valider par clique sur oui") 
public void Valider_par_clique_sur_oui() {
	ModifSitePage.Valider_par_clique_sur_oui();	
}

@Test
@Then("Popup du modification doit etre ferme")
public void popup_du_modification_doit_etre_ferme() {
   ModifSitePage.popup_du_modification_doit_etre_ferme();


}

@Test
@When("Selectionner un type")
public void Selectionner_un_type() throws InterruptedException {
	ModifSitePage.Selectionner_un_type();
}














}














