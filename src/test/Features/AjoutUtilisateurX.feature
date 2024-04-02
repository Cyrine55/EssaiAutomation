
@tag
Feature: Ajout Utilisateur X
Background:
    Given Utilisateur ouvre la page de connexion
    When Entrer un identifiant valide
    And Entrer un mot de passe valide
    And Valider les informations et cliquer sur le bouton de connexion
    Then Connexion avec succès et redirection sur linterface Gestion des utilisateurs

  @Utilisateur
  Scenario: Ajout Utilisateur X
  Given Utilisateur authentifié et dans la page gestion utilisateur
  When Cliquer sur le bouton Ajouter
  And j ajoute l utilisateur suivant 
   |Prenom|Nom   |Identifiant  | Adresse mail  |Role  | Sites |
   |Test12 |Auto12 |use12r |hubone.fr| Admin |site2 |
   And Generer un mot de passe
   And Cliquer sur Enregistrer
   Then Utilisateur ajoute avec succes
   And je ferme le navigateur
   