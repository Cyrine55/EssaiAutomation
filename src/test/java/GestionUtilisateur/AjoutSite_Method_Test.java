package GestionUtilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Formation.Utils.BaseUtils;
import io.cucumber.datatable.DataTable;

public class AjoutSite_Method_Test extends BaseUtils{
	@Before
	public void setUp() {
		initializeDriver();
	}
	
	@Test
	public void liste_des_sites_affichees() {}
	
	@Test
	public void cliquer_sur_Ajouter() {
		
}
 @Test
 public void remplir_informations_du_site(DataTable dataTable) {}
 
 @Test
 public void cliquer_sur_suivant() {}
	
 @Test
 public void remplir_zone() {}
 
 @Test
 public void cocher_statut() {}
 
 @Test
 public void enregistrer() {}
 
 @Test
 public void site_enregistre() {
}
@Test
public void remplir_informations_invalides_du_site() {
}
@Test
public void messages_erreurs_affiches() {}
@Test
public void SuivantBtndisable() {}

@Test
public void saisir_caracteres_id_dans_la_zone_de_recherche() {}

@Test
public void site_relatif_au_id_affiche() {}

@Test
public void saisir_caracteres_id_nexiste_pas(){}

@Test
public void liste_vide_avec_message_aucune_donnee() {}


@After
	public void closenav() {
		close();
	}
	












}