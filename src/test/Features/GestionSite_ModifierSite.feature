@tag
Feature: Modifier un site 

  Background: 
    Given Utilisateur ouvre la page de connexion
    When Entrer un identifiant valide
    And Entrer un mot de passe valide
    And Valider les informations et cliquer sur le bouton de connexion
    
    @Site
    Scenario: Modifier Site Valide
    Given Liste des sites affichees
    When Cliquer sur crayon modifier 
    And Popup affichee avec champ ID et type desactivee
    And Saisir les informations suivantes
    |Nom du site|Adresse   |Code postal  |Ville |
    |Test12 |Auto12 |use12r |hubone.fr|
     And Cliquer sur Suivant
     And Saisir nouveau nom du zone et un nouveau statut
     And Enregistrer
    