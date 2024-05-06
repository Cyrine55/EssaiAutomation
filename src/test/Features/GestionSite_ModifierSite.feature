@tag
Feature: Modifier un site 

  Background: 
    Given Utilisateur ouvre la page de connexion
    When Entrer un identifiant valide
    And Entrer un mot de passe valide
    And Valider les informations et cliquer sur le bouton de connexion
    
    #@Site
    #Scenario: Modifier Site Valide
   # Given Liste des sites affichees
   # When Selectionner un sitee
   # When Cliquer sur crayon modifier 
   # And Popup affichee avec champ ID et type desactivee
   # And Saisir les informations suivantes
    #|Nom du site1|Adresse1   |
  #  |cyrinetestd1 |cyrine2tegjd1 |
    # And Cliquer sur Suivant
    # And Saisir nouveau nom du zone et un nouveau statut
    # And Enregistrer
  #Then modification avec succes
    
    
    #@Site
    #Scenario: Modification Site invalide avec champ NomSite vide
    #Given Liste des sites affichees
    #When Selectionner un sitee
    #When Cliquer sur crayon modifier
    #Then le bouton Suivant doit etre desactive apres vidage du champ
    
    
   # @Site
    #Scenario: Annuler la modification du site
    #Given Liste des sites affichees
    #When Selectionner un sitee
    #When Cliquer sur crayon modifier
    #And Cliquer sur le bouton Annuler
    #And Valider par clique sur oui
    #Then Popup du modification doit etre ferme
    
    
    @Sitetest
    Scenario: Filtre site par type et ville valide avec menu droit
     Given Liste des sites affichees
     When Selectionner un type 
     When Saisir une ville
     And cliquer sur le bouton Valider
     Then Resultat correspondante affichee
     