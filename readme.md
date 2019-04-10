Merci de vous intéresser à Escalade P6 :)

Pour installer la webapp JEE, nous conseillons les étapes suivantes :


A) METHODE RAPIDE 

sur une machine Windows ou Ubuntu, nous vous conseiller de télécharger le fichier .jar et d'exécuter la commande suivante :
java -jar escaladeP6-1.0-SNAPSHOT.jar
Cela déploiera automatiquement l'application sur le port 8080 de votre machine. Et vous utiliserez la BDD de démo hébergée sur le serveur VPS OVH.

B) METHODE PERSONNALISEE

1) créer une base de données PostgreSQL
2) générer les tables avec le script createDB.sql

2bis) optionnel : un jeu de données démo est disponibles grâce au script dataGlobal.sql
(Nous avons retirer les fichiers PDB stockés pour que l'import des données soient plus léger)

3) Pour connecter la webapp à votre BDD il faudra importer le projet complet dans votre IDE et modifier les données de connexion dans le fichier application.properties.
4) Générer un fichier .jar avec Maven et déployer !


Bonne utilisation !

Julien M.