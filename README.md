# Mon application Meteo

## Réponses aux questions - Partie 1

### Description des Dépendances : Étape 5

Ce projet utilise plusieurs dépendances pour son fonctionnement. Voici une description succincte de chaque dépendance ajoutée :

- **Spring Boot Starter Web** :
  - Fournit des outils pour développer des applications web avec Spring Boot, incluant la configuration du serveur web intégré, la gestion des requêtes HTTP, etc.

- **Spring Boot Starter Data JPA** :
  - Simplifie l'utilisation de JPA (Java Persistence API) avec Spring Boot pour la gestion de la couche de persistance des données dans les applications Java.

- **Spring Boot Starter Thymeleaf** :
  - Intègre Thymeleaf avec Spring Boot, offrant un moteur de templates pour la création de vues HTML dynamiques dans les applications web.

- **H2 Database** :
  - Base de données relationnelle en mémoire souvent utilisée pour le développement et les tests, légère, facile à configurer et sans nécessiter de serveur séparé.

- **Spring Boot DevTools** :
  - Fournit des outils pour faciliter le développement, incluant le rechargement automatique de l'application lors de modifications du code, la configuration simplifiée, etc.

- **Hibernate** (inclus via Spring Boot Starter Data JPA) :
  - Framework ORM pour la communication entre une application Java et une base de données relationnelle, simplifiant l'accès et la manipulation des données avec des objets Java.

### Étape 12
![Etape12Partie1](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/c3400e77-0f9f-499f-8c50-3b99864f1ae1)

### Étape 13

1. **Paramétrage de l'URL d'appel /greeting :**
   - L'URL d'appel `/greeting` est paramétrée dans le contrôleur (`HelloWorldController`) avec l'annotation `@GetMapping("/greeting")` au-dessus de la méthode `greeting`.

2. **Choix du fichier HTML à afficher :**
   - Le choix du fichier HTML à afficher est réalisé via la ligne de code `return "greeting";` dans la méthode `greeting` du contrôleur. L'instruction `return "greeting";` indique que le nom de la vue (dans ce cas, "greeting.html") à afficher est "greeting".

3. **Transmission du nom pour dire bonjour avec le second lien :**
   - Le nom à qui nous disons bonjour est transmis en tant que paramètre de requête dans l'URL. Dans le second lien (`http://localhost:8080/greeting?name=ENSIM`), le paramètre `name` est ajouté à l'URL avec la valeur `ENSIM`. Ce paramètre est récupéré dans le contrôleur via `@RequestParam(name="nameGET", ...)` dans la méthode `greeting`.

### Étape 14

![Etape14Partie1](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/0efb0388-b8b4-49da-8e70-2cb7b1ef3cdc)

### Étape 17

Après avoir relancé l'application Spring Boot et accédé à nouveau à la console H2 via [http://localhost:9090/h2-console](http://localhost:9090/h2-console), une nouvelle table nommée `Address` a été ajoutée dans la base de données. Cette table `Address` correspond à la classe `Address` annotée avec `@Entity` dans le code source, définissant ainsi la structure de la table dans la base de données H2.

### Étape 18

L'apparition d'une nouvelle table dans la base de données suite à l'intégration d'une classe annotée avec @Entity (comme la classe Address dans votre cas) est directement liée à l'utilisation de Hibernate, une bibliothèque ORM (Object-Relational Mapping) intégrée dans le cadre de développement Spring via la dépendance Hibernate de Spring Boot.

Hibernate facilite la persistance des objets Java dans une base de données relationnelle en simplifiant le mapping entre les objets Java et les tables de la base de données. Lorsque vous ajoutez une classe annotée avec @Entity dans votre code source, Hibernate interprète cette annotation comme un indicateur pour créer une table correspondante dans la base de données.

### Étape 20

![Etape20Partie1](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/33166907-2f51-4a5f-a6db-5adf1af6e939)


### Étape 22

L'annotation `@Autowired` en Java est utilisée dans le contexte de Spring pour effectuer l'injection de dépendances automatique des composants gérés par le conteneur Spring. Lorsqu'elle est utilisée au-dessus d'un champ, d'un constructeur ou d'une méthode `set`, Spring identifie automatiquement le bean correspondant au type de ce champ, du paramètre du constructeur ou de la méthode `set`, puis l'injecte dans la classe où se trouve l'annotation `@Autowired`.

Cette annotation permet de simplifier la gestion des dépendances en laissant Spring rechercher et injecter automatiquement les dépendances nécessaires dans les classes, favorisant ainsi la modularité et la cohérence au sein de l'application.

### Étape 26

1. **Ajouter l'auteur dans l'entité « Address.java » :**
   private String auteur;

2. **Dans le fichier data.sql, ajoutez la donnée :**
   INSERT INTO address (id, creation, content, auteur) VALUES (1, CURRENT_TIMESTAMP(), '57 boulevard demorieux', 'ikram');
    INSERT INTO address (id, creation, content, auteur) VALUES (2, CURRENT_TIMESTAMP(), '51 allee du gamay, 34080
    montpellier','aya');

3. **Côté vue, utilisez la nouvelle donnée et affichez-la :**

   ```html
   <span th:text="${address.content} + ' -> ' + ${address.author}"></span>

![Etape26Partie1](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/78969296-ea67-4434-bb40-d9979719dd9f)


### Étape 27

![Etape27Partie1](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/aeec2d22-ae49-4ed4-ad0b-1cde8f69f15d)


### Étape 30

Pour inclure Bootstrap dans votre projet, on ajoute la dépendance de bootstrap dans le fichier pom.xml.
Pour utiliser Bootstrap dans les pages HTML (par exemple, addresses.html, greeting.html, etc.), on ajoute la ligne (link...) dans la section head de chaque fichier HTML où on souhaite utiliser les fonctionnalités de Bootstrap.

## Réponses aux questions - Partie 2

### Utilisation d'API Etalab pour récupérer la latitude et la longitude et l'API Meteo Concept pour récupérer les données du méteo

![APIEtalab](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/218f535c-d34d-439a-81fd-121785d438b1)

![APIMeteoConcept](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/f1861ceb-acc9-4d40-a724-b1feddd57470)

### Demo

La première page est la page 'Home, où l'on entre l'adresse que l'on souhaite pour afficher sa météo.

![HomePage](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/501ef9e9-afb8-44d6-9a59-b9b1364af0d2)

Ensuite, lorsque l'on clique sur 'Get the weather at the given address', la page 'Météo' s'affiche, affichant les informations météorologiques de l'adresse saisie, si cette dernière est correcte.

![MeteoPage2](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/52fb0cde-a791-4f71-94d0-9fa436ad73dc)

![MeteoPage3](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/3f52a1eb-a227-4403-a47f-d72ad288ed74)

Si l'adresse entree n'est pas correcte on affiche une erreur.

![error](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/6ce838af-c25d-4d29-a80f-cd8e2acf725d)

Ensuite, nous avons un champ contenant l'adresse accompagné d'un bouton 'Lister'. Si l'on clique sur ce bouton, une page de 'Recherche' s'affiche, répertoriant toutes les informations météorologiques déjà enregistrées dans la base de données pour cette adresse.

![MeteoPage](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/71c4161f-3200-479b-8c84-04bb83cb03a1)

![Lister](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/9f30c083-62d6-40e1-9121-145185835d77)

On peut aussi naviger vers cette page 'Recherche'.

![RecherchePage](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/6ed055c4-1ac0-415e-9b5c-89e69045d011)

On peut cherche une adresse.

![Rechercher](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/42f17e1e-23af-44cc-bbd2-a4df5510ec64)

Et on peut supprimer une ligne en cliquant sur 'Delete', par exemple ici j'ai supprimer la ligne de 'Paris'.

![RecherchePage](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/662c8129-0bc3-4426-ae41-6f15ad1894fb)

![supprimer](https://github.com/IkramHaddouch/ProjetMeteo/assets/115647126/eb71f224-ef16-49d9-98cc-ab9c166c5069)

### Réponses aux questions de l'étape 6

1. **Faut-il une clé API pour appeler MeteoConcept ?**
Oui, MeteoConcept nécessite une clé API pour effectuer des appels à son service. La clé API est utilisée pour authentifier et autoriser les requêtes vers leur API.

2. **Quelle URL appeler ?**
L'URL à appeler pour obtenir des prévisions météorologiques de MeteoConcept peut varier selon le service auquel on a souscrit. Habituellement, l'URL que j'ai utilisé : <https://api.meteo-concept.com/api/forecast/daily/0>. Cependant, assurez-vous de consulter leur documentation officielle pour obtenir l'URL exacte à utiliser.

3. **Quelle méthode HTTP utiliser ?**
Pour récupérer des données météorologiques à partir de MeteoConcept, on utilisere généralement la méthode HTTP GET. Les requêtes sont généralement effectuées via cette méthode pour récupérer des données météorologiques.

4. **Comment passer les paramètres d'appels ?**
Les paramètres tels que les coordonnées GPS (latitude et longitude) peuvent être transmis à MeteoConcept dans l'URL. Par exemple, on peut ajouter les paramètres dans l'URL après un point d'interrogation (?), comme <https://api.meteo-concept.com/api/forecast/daily/0?token=VOTRE_CLE_API&latlng=48.8566,2.3522> où token représente votre clé API et latlng contient les coordonnées géographiques.

5. **Où est l'information dont j'ai besoin dans la réponse :**

Pour afficher la température du lieu visé par les coordonnées GPS :
La température peut être présente dans les données renvoyées par MeteoConcept sous forme de champs spécifiques tels que tmin et tmax. Ces champs peuvent être trouvés dans la réponse JSON.

Pour afficher la prévision de météo du lieu visé par les coordonnées GPS :
Les prévisions météorologiques comprennent généralement des informations sur les conditions météorologiques futures telles la probabilité de pluie, la vitesse du vent, le nombre d'heures d'ensoleillement etc. Ces informations sont souvent organisées dans des objets ou des tableaux dans la réponse JSON. Les clés ou les champs correspondants à ces informations sont : probarain, wind10m, sunHours.

## Mon Projet

Lien vers mon projet GitHub :

[Lien vers mon projet GitHub](https://github.com/IkramHaddouch/ProjetMeteo.git)
