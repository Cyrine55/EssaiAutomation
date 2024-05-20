@tag
Feature: Export Expéditions 

  Background: 
    Given Utilisateur ouvre la page de connexion
    When Entrer un identifiant valide
    And Entrer un mot de passe valide
    And Valider les informations et cliquer sur le bouton de connexion
    
    @Stock
    Scenario: Exporter liste des expéditions existante
    Given Ecran Expéditions affiche
    When choisir un interval de date depuis calendrier
    And liste des expeditions affichee
    And Cliquer sur le bouton Exporter
    Then fichier export telecharge
    