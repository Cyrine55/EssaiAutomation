@tag
Feature: Ajouter un site valide

  Background: 
    Given Utilisateur ouvre la page de connexion
    When Entrer un identifiant valide
    And Entrer un mot de passe valide
    And Valider les informations et cliquer sur le bouton de connexion

  # @Site
 # Scenario: Ajouter un site avec donnes valides
  # Given Liste des sites affichees
  # When cliquer sur Ajouter
  # And Remplir informations du site
   #| ID       | Nom         | Type       | Adresse     | Code postal | Ville  |
   #| Sitetvvest | Svitetesvts | Restaurant | AdresseAuto |  04034 | VilleAuto5 |
  #And Cliquer sur Suivant
#  And Remplir Zone
 # And Cocher Statut
 #  And Enregistrer
 # Then Site enregistre
  
     
 #@Site
  #Scenario: Ajouter un site avec donnes errones
  #  Given Liste des sites affichees
  #  When cliquer sur Ajouter
  #  And Remplir informations invalides du site
    #  | ID                                                  | Nom                             | Type             | Adresse     | Code postal | Ville                           |
    #  | IdsiteIdsiteIdsiteIdsiteIdsiteIdsiteIdsiteIdsiteIcv | NomSiteNomSiteNomSiteNomSitnoms | Centre de lavage | AdresseAuto | test        | Villetest|
  #  Then Messages erreurs affiches

    
    #@Site
   # Scenario: Rechercher des sites par ID 
   # Given Liste des sites affichees
   # When Saisir caracteres ID dans la zone de recherche
   # Then Site relatif au ID affiche
    
    
   # @Site
   # Scenario: Rechercher des sites par ID non trouve
   # Given Liste des sites affichees
   # When Saisir caracteres ID nexiste pas
   # Then liste vide avec message aucune donnee
    
    
    @Site
    Scenario: Ajout Site par import fichier valide
    Given Liste des sites affichees
    When cliquer sur le bouton importer
    And cliquer sur le bouton parcourir et selectionner un fichier 
    And cliquer sur importer
    Then fichier ajouter avec succes 
    
    
    
    
    
    
    
    