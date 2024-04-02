
@tag


Feature: Authentification à lapplication GT 
#Background:
  #  Given Utilisateur ouvre la page de connexion
  #  When Entrer un identifiant valide
   # And Entrer un mot de passe valide
   # And Valider les informations et cliquer sur le bouton de connexion
    #Then Connexion avec succès et redirection sur linterface Gestion des utilisateurs
   @Utilisateur
  Scenario: Authentification avec email et mdp valides
    Given Utilisateur ouvre la page de connexion
    When Entrer un identifiant valide
    And Entrer un mot de passe valide
    And Valider les informations et cliquer sur le bouton de connexion
    Then Connexion avec succès et redirection sur linterface Gestion des utilisateurs
  

