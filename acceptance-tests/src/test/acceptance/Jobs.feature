Feature: Fonctionnalités de ma page de jobs
  Scenario: Vérification de la punchline
    Given je suis sur la homepage
    When je clic sur le bouton "Carrières"
    Then Then je suis sur la page "https://www.meetup.com/fr-FR/careers/"
    And la puncline doit être "Aidez les gens à trouver leur communauté. Encouragez-les à l'améliorer."