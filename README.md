# README du site de vente de peinture
## Préparation de l'environnement
KLAKADOS est un application web en JAVA 8 avec le Framework SPRING, pour l'executer il faut suivre les étapes suivantes (des liens utilies sont mis pour accéder à la page d'installation) :
- Etape 1: Installer l'IDE IntelliJ IDEA 2021.2.2 qui va permettre de compiler et executer le programme. https://www.jetbrains.com/idea/promo/
- Etape 2: Les informations sur les produits et les utilisateurs du site sont stockés dans une base de donnée MySQL. Afin d'y acceder il faut installer WampServer (va vous permettre de se connecter à un serveur MySQL, et d'acceder à phpMyAdmin: l'administrateur Web des bases MySQL). https://www.wampserver.com/en/download-wampserver-64bits/
- Etape 3: Le front end de l'application est fait avec Angular. De ce fait, il vous faudra quelques outils indispensables pour lancer l'application Angular en toute tranquillité.
  - Installez Node et npm: Vous pouvez télécharger et installer la version LTS de Node sur https://nodejs.org/fr/, ce qui installera également npm.
  - Installez le CLI d'Angular: Installez-le sur votre ordinateur depuis une ligne de commande avec (Linux) : # npm install -g @angular/cli OU $ sudo npm install -g @angular/cli

## Lancement de l'application
Une fois tous les outils sont installé, vous pouver lancer l'application et celà en deux phase:
### Back end: 
Dans l'IDE, ouvrez le fichier contenant le code source du back end. Ensuite, lancez WampServer et ouvrez phpMyAdmin [utilisateur: root , mot de passe :  ]. Finalement, le serveur local est prêt, vous pouvez executer le back end.
### Front end:
Dans une nouvelle fenêtre, ouvrez le fichier contenant le code source du front end. **Accepter d'installer npm!** Et executez le programme.
Le site est prêt, et vous pouvez l'ouvrir d'ores et déjà dans votre navigateur (avec le lien générer dans le terminal) !

## Navigation sur l'application
Une fois sur le site, pour cette première version du site (sprint1), vous pouvez consulter la liste des articles disponibles et lire les details de chaque produit apart. Ou encore, vous pouvez créer un compte et devenir un client du site afin de pouvoir tester l'experience client. Avec cela, vous pouvez ajouter un article à votre panier pour un futur achat.



