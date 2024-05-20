package StepDefinitions;

import org.junit.Test;

import Formation.Utils.BaseUtils;
import Pages.Stock_ExpeditionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Stock_ExpeditionStepDef extends BaseUtils {
	Stock_ExpeditionPage stock_ExpeditionPage=new Stock_ExpeditionPage();
	
	@Test
	@Given("Ecran Expéditions affiche")
	public void ecran_expéditions_affiche() {
		stock_ExpeditionPage.ecran_expéditions_affiche();
	}
@Test
@When("choisir un interval de date depuis calendrier")
public void choisir_un_interval_de_date_depuis_calendrier() throws InterruptedException {
	stock_ExpeditionPage.choisir_un_interval_de_date_depuis_calendrier();
}
}
