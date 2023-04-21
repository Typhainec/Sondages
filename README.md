# Sondages

Le projet **Sondage** est un Webservice qui permet de créer, lister, éditer et supprimer des sondages sur une page web selon le modèle CRUD. Un Webservice est une application qui permet d’échanger des données avec d’autres applications web. Le projet utilise SpringFramework, Spring Data JPA ainsi que l'API REST pour effectuer ces fonctionnalités.

# Les technologies utilisées 

-  Spring Framework : c'est un framework open source pour le développement d'applications Java. Il fournit un ensemble de fonctionnalités pour le développement d'applications web, notamment la gestion des requêtes HTTP, la gestion des transactions, la gestion des sessions et la gestion des vues.
    
-   Spring Data JPA : c'est un sous-projet de Spring qui fournit un ensemble de fonctionnalités pour faciliter l'implémentation de l'accès aux données en utilisant l'API Java Persistence (JPA). Il fournit des méthodes de base pour la récupération et la manipulation des données stockées dans une base de données relationnelle.
    
-   REST : c'est un style d'architecture pour les systèmes distribués qui se concentre sur les ressources, leurs états et les opérations qui peuvent être effectuées sur ces ressources. Le protocole HTTP est utilisé pour la communication entre les clients et les serveurs. Les opérations suivent généralement le modèle CRUD (Create, Read, Update, Delete).
    
-   MySQL : c'est un système de gestion de base de données relationnelle open source. Il est utilisé pour stocker et récupérer les données de l'application.
    
-   MAMP : c'est un environnement de développement web pour Mac OS X qui fournit Apache, MySQL et PHP. Il est utilisé pour héberger la base de données MySQL utilisée par l'application.
    
-   IntelliJ IDEA : c'est un environnement de développement intégré pour Java. Il est utilisé pour développer, déployer et déboguer l'application.


# Lancement du projet

Ce-dernier se lance via la classe  **SondagesCApplication** et est visible sur votre navigateur depuis l'url suivante: **http://localhost:8080/rest/sondage**
Cette classe est la classe principale du projet. Elle contient la méthode main qui est exécutée lors du lancement de l'application. La classe utilise l'annotation @SpringBootApplication qui permet de configurer automatiquement l'application Spring Boot. La méthode main appelle SpringApplication.run() pour lancer l'application.

# Vérification des APIs 

Il est possible de vérifier l'intégrité des API à l'adresse suivante: **http://localhost:8080/swagger-ui/index.html**


## Les points d'entrée du projet  

-   **GET /sondage**  : liste de tous les sondages dont la date de cloture est dans le futur
-   **GET /sondage/{id}**  : lecture du sondage {id} et retour au format JSON
-   **POST /sondage**  : création d'un nouveau sondage puis réponse HTTP 200
-   **PUT /sondage/{id}**  : modification du sondage {id} puis réponse HTTP 200
-   **DELETE /sondage/{id}**  : suppression du sondage {id} puis réponse HTTP 200

## Les test JUnit correspondants

Les points d'entrée listés ont respectivement leur test unitaire dans le package **test/java/f.simplon.sondagec**.Voici les classes correspondantes à chaque tests unitaires: 

- **TestTousLesSondages** : Ce test est utilisé pour tester une application qui expose des services REST en Java avec le framework Spring. Il vérifie si une liste de sondages peut être récupérée depuis l'API REST et si elle n'est pas vide. Pour cela, le test envoie une requête HTTP GET à l'API REST et stocke la liste des sondages retournée. Il effectue ensuite une assertion pour vérifier que la liste des sondages n'est pas vide. Ce test permet de s'assurer que l'API REST fonctionne correctement.

- **TestSondageByID** : Cette classe unitaire est utilisée pour tester si la méthode "getSondageById" du contrôleur fonctionne correctement en retournant un sondage spécifique à partir de son identifiant. Elle utilise le framework Spring pour tester une application REST en Java. Le test crée un objet "Sondage" pour les besoins du test, sauvegarde cet objet en base de données, et appelle la méthode "getSondageById" en passant l'identifiant de l'objet créé. Ensuite, le test effectue plusieurs assertions pour vérifier que les propriétés de l'objet retourné correspondent à celles de l'objet créé précédemment. En somme, ce test vise à s'assurer que la méthode "getSondageById" retourne les propriétés correctes pour un sondage donné.

- **TestPostSondage** : Ce test unitaire vise à tester la méthode "save" qui permet de créer un nouveau sondage dans la base de données. Le test crée un objet "Sondage" avec une question et une description, définit un en-tête HTTP et une entité HTTP à l'aide de l'objet "Sondage", puis appelle la méthode "postForEntity" pour envoyer l'objet "Sondage" au serveur en tant que corps de la requête HTTP POST. Le test vérifie ensuite que la réponse du serveur a un statut "200 OK". En somme, ce test sert à s'assurer que la méthode "save" fonctionne correctement en créant un nouveau sondage dans la base de données.

- **TestPutSondage** : Ce test effectue une requête PUT en utilisant un objet Sondage pour mettre à jour les informations d'un sondage identifié par un ID. Il utilise RestTemplate pour envoyer la requête et vérifie que la réponse de la requête est OK. Ensuite, il vérifie que les informations du sondage ont été mises à jour en effectuant une requête GET pour récupérer les informations du sondage mis à jour et en comparant avec les valeurs de l'objet Sondage envoyé dans la requête PUT.

- **TestDeleteSondage**: Ce test unitaire envoie une requête DELETE pour supprimer un sondage en utilisant une URL qui contient l'identifiant du sondage à supprimer. L'identifiant est défini à 1L et la requête est envoyée à "http://localhost:8080/rest/sondage/{id}

# Structure du code

Le code se divise en plusieurs packages, classes et interface dont les utilisations sont décrites ci-dessous. 

## SondageController

La classe **SondageController** se trouve dans un package **controller** et à pour rôle de de gérer les requêtes HTTP relatives aux sondages en utilisant les méthodes de la classe SondageRepository. Les différentes routes définies (/rest/sondage, /rest/sondage/{id}, /rest/sondage/save, /rest/sondage/update/{id}, /rest/sondage/delete/{id}) permettent de respectivement afficher tous les sondages existants en base de données, afficher un sondage particulier, enregistrer un nouveau sondage, mettre à jour un sondage existant et supprimer un sondage existant. Les requêtes HTTP sont associées aux méthodes du controller (getSondage(), getSondageById(Long id), saveSondage(Sondage sondage), updateSondage(Long id, Sondage updateSondage), deleteSondage(Long id)) qui renvoient ou modifient les données de la base de données via les méthodes correspondantes de SondageRepository.


## SondageRepository

L'interface SondageRepository à pour rôle de définir les méthodes pour interagir avec la base de données concernant l'entité Sondage. Elle étend JpaRepository qui fournit déjà des méthodes de base comme findAll(), findById(), save(), deleteById(), etc. Cette interface permet donc de faciliter l'implémentation de la couche DAO (Data Access Object) pour l'entité Sondage.

## Sondage

Cette classe Java est définie dans le package "fr.simplon.sondagesc.entity". Elle représente une entité Sondage et est annotée avec "@Entity" pour être persistante en base de données via JPA (Java Persistence API). Elle contient les champs suivants :

- Id : un identifiant unique automatiquement généré par la base de données.
- Description : une chaîne de caractères de longueur maximale de 120 caractères et obligatoire.
- Question : une chaîne de caractères de longueur maximale de 120 caractères et facultative.
- Creation : une LocalDate représentant la date de création du sondage, au format "dd/MM/yyyy".
- Cloture : une LocalDate représentant la date de clôture du sondage, au format "dd/MM/yyyy".
- Personne : une chaîne de caractères de longueur maximale de 64 caractères et obligatoire, représentant le nom de la personne qui a proposé le sondage.

Les différents attributs de la classe représentent les colonnes de la table, avec des annotations telles que @Column pour définir les propriétés de la colonne. La classe a également des annotations pour la sérialisation/désérialisation en JSON (@JsonFormat) et pour la conversion de dates (@DateTimeFormat et @Temporal).  Cette classe contient également un constructeur avec tous les champs en paramètres, ainsi que les getters et setters pour chaque champ.

## Evolution du projet sondage

Ce projet de sondage est conçu pour évoluer au fil du temps, en fonction des besoins et des commentaires de la communauté. Nous sommes ouverts à toutes les suggestions d'amélioration ou de nouvelles fonctionnalités, alors n'hésitez pas à nous faire part de vos idées. Parmi les nouvelles fonctionnalités prévues, la création d'un système de vote visible sur une page HTML stylisée, un bouton "vote" devant chaque sondage afin d'enregistrer les avis.

## Récupération du projet sondage sur Github

1.  Accédez au site web de Github à l'adresse [https://github.com/](https://github.com/).
2.  Connectez-vous à votre compte Github ou créez-en un si vous n'en avez pas encore.
3.  Recherchez le projet sondage en utilisant la fonction de recherche en haut de la page.
4.  Cliquez sur le projet sondage dans les résultats de recherche pour accéder à la page du projet.
5.  Sur la page du projet, cliquez sur le bouton "Fork" en haut à droite pour créer une copie du projet sur votre compte Github.
6.  Une fois le projet forké, vous pouvez le cloner sur votre ordinateur en utilisant la commande "git clone <URL du projet>" dans votre terminal.
7.  Vous pouvez ensuite travailler sur le projet en local, effectuer des modifications et les pousser vers votre propre version du projet sur Github en utilisant la commande "git push".


### Auteur : Typhaine Claudepierre
