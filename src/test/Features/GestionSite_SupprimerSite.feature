@tag
Feature: Supprimer un site 

  Background: 
    Given Utilisateur ouvre la page de connexion
    When Entrer un identifiant valide
    And Entrer un mot de passe valide
    And Valider les informations et cliquer sur le bouton de connexion
    
    
@Site
Scenario: Supprimer site
Given Liste des sites affichees
#When Selectionner un site
And Cliquer sur le bouton Supprimer
And le message de suppression est affiche "Êtes-vous sûr de bien vouloir supprimer ce site?" 
And Cliquer sur oui 
Then Site supprime avec un message succes   