
@tag
Feature: Ajout Utilisateur

Background:
    Given Utilisateur ouvre la page de connexion
    When Entrer un identifiant valide
    And Entrer un mot de passe valide
    And Valider les informations et cliquer sur le bouton de connexion
    Then Connexion avec succès et redirection sur linterface Gestion des utilisateurs

  @Utilisateur
  Scenario: Ajout Utilisateur avec infos valides
    Given Utilisateur authentifié et dans la page gestion utilisateur
    When Cliquer sur le bouton Ajouter
    And Saisir Prenom et identifiant
    And Choisir un role
    And Saisir une adresse mail valide
    And Generer un mot de passe
    And Choisiir un site
    And Cliquer sur Enregistrer
   Then Utilisateur ajoute avec succes 
   And je ferme le navigateur
    
  


