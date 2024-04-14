package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import Formation.Utils.BaseUtils;

public class ModifierSitePage extends BaseUtils {

int index=4;
	public void cliquer_sur_crayon_modifier() {
	  //  WebElement crayonmodif=driver.findElement(By.xpath("//tbody/tr[7]/td[7]/em[1]"));
	    
	}
	
	public void selectionner_un_sitee() {
      List<WebElement> CheckSiteList=driver.findElements(By.xpath("//input[@type='checkbox']"));
		// Sélectionner un checkbox avec un index que nous l'identifié 
		if (index >= 0 && index < CheckSiteList.size()) {
	        CheckSiteList.get(index).click();
	    } else {
	        System.out.println("Index hors limites.");
	    }
		
	}
	
	public void popup_affichee_avec_champ_id_et_type_desactivee() {
	    WebElement IDSite=driver.findElement(By.xpath("//input[@placeholder='Id du site']"));
	    assertFalse("Le champ n'est pas désactivé", IDSite.isEnabled());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
