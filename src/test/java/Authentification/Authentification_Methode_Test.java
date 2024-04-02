package Authentification;




import org.junit.After;
import org.junit.Test;


import Formation.Utils.BaseUtils;
import io.cucumber.java.Before;

public class Authentification_Methode_Test extends BaseUtils {
   
	    @Before
	    public void setUp() {
	    	initializeDriver();
	    }
	    
	   @Test
	   public void Entrer_un_identifiant_valide() {}
	    
	   @Test
	   public void entrer_un_mot_de_passe_valide(){}
	   
	    @Test
	    public void valider_les_informations_et_cliquer_sur_le_bouton_de_connexion() {}
	    
	   @Test
	   public void connexion_avec_succès_et_redirection_sur_linterface_gestion_des_utilisateurs() {}
	   
	   @After
	   public void down() {
		   close();
	   }
	  
}
	 
	


