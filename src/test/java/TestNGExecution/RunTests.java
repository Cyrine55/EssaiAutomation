package TestNGExecution;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AjoutUtilisateurPage;

public class RunTests {
	
	AjoutUtilisateurPage Ajoutpage=new AjoutUtilisateurPage();
	String role = "Responsable";
	String Sitename="site2";
 
@BeforeTest
public void Authentification()  {
	  
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
