package StepDefinitions;

import org.junit.Test;

import Formation.Utils.BaseUtils;
import Pages.ModifierSitePage;
import io.cucumber.java.en.When;

public class ModifierSiteStepDef extends  BaseUtils{
ModifierSitePage ModifSitePage=new ModifierSitePage();
@Test
@When("Cliquer sur crayon modifier")
public void cliquer_sur_crayon_modifier() {
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
}
