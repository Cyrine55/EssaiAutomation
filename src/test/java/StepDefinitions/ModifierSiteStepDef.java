package StepDefinitions;

import org.junit.Test;

import Formation.Utils.BaseUtils;
import Pages.ModifierSitePage;
import io.cucumber.java.en.When;

public class ModifierSiteStepDef extends  BaseUtils{
ModifierSitePage ModifSitePage=new ModifierSitePage();
@Test
@When("Cliquer sur crayon modifier")
public void cliquer_sur_crayon_modifier() throws InterruptedException {
	ModifSitePage.cliquer_sur_crayon_modifier();
}
@Test
@When("Selectionner un sitee")
public void selectionner_un_sitee() {
	ModifSitePage.selectionner_un_sitee();
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
public void saisir_nouveau_nom_du_zone_et_un_nouveau_statut() throws InterruptedException  {
	ModifSitePage.saisir_nouveau_nom_du_zone_et_un_nouveau_statut(); 
}


}
