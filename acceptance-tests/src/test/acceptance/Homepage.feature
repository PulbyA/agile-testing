Feature: Fonctionnalités de ma page d'accueil
	Scenario: Vérification du titre et de la description
		Given je suis sur la homepage
		Then le titre doit être "Partagez vos passions | Meetup"
		And la description contient "Partagez vos passions et faites bouger votre ville"
	Scenario: Vérification des puchlines
		Given je suis sur la homepage
		Then la punchline doit être "Le monde vous tend les bras"
		And La sous punchline doit être "Rejoignez un groupe local pour rencontrer du monde, tester une nouvelle activité ou partager vos passions."
	Scenario: Accéder aux événements près de chez soi depuis la page d'accueil
		Given je suis sur la homepage
		And le bloc des "Groupes près de vous" est présent
		When je clic sur le bouton "Voir tout"
		Then je suis sur la page "https://www.meetup.com/fr-FR/find/"
		And la recherche est initialisé sur un rayon de "5km" autour de "Paris", FR

