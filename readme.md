Merci de vous intéresser à Escalade P6 :)

Pour installer la webapp JEE, nous conseillons les étapes suivantes :

1) créer une base de données PostgreSQL
2) générer les tables avec le script createDB.sql

2bis) optionnel : un jeu de données démo est disponibles grâce au script dataGlobal.sql
(Nous avons retirer les fichiers PDB stockés pour que l'import des données soient plus léger)

3) sur une machine Windows ou Ubuntu, nous vous conseiller de télécharger le fichier .jar et d'exécuter la commande suivante :
java -jar escaladeP6-1.0-SNAPSHOT.jar

Cela déploiera automatiquement l'application sur le port 8081 de votre machine.
Pour connecter la webapp à votre BDD il faudra importer le projet dans votre IDE et modifier les données de connexion dans le fichier application.properties.


Bonne utilisation !

Julien M.