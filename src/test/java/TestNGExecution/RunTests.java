package TestNGExecution;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Formation.Utils.BaseUtils;
import Pages.AjoutUtilisateurPage;

public class RunTests extends BaseUtils {
	
	AjoutUtilisateurPage Ajoutpage=new AjoutUtilisateurPage();
	String role = "Responsable";
	String Sitename="site2";
 
@BeforeTest
public void Authentification()  {
	initializeDriver();
}

@AfterTest
public void Close_browser()  {
	  
}


  @Test
  public void AjoutUtilisateur() throws InterruptedException {
	  
	  Ajoutpage.cliquer_sur_le_bouton_ajouter();
	  Ajoutpage.saisir_prenom_et_identifiant();
	  Ajoutpage.choisir_un_role(role);
  }
}
