# Projet Agregio V2

### 2 contextes identifiés : 
* Parc
* Offre
### Design applicatif : Monolithe modulaire
#### par contexte :
* **Parc** :
  * ***Sans réelle couche*** : administration sans règle métier et on fait confiance aux administrateur pour les données transmises. Cela implique :
    * Une **pyramide des tests inversés**
    * Pas de modèle métier. (Il y aurait quand même eu un mapping vers des entités de persistence si une base était montée) 
  * ******
* **Offre** : 
  * **Architecture hexagonale** : La complexité métier est présente. Cela implique : 
    * Une **pyramide de tests** respectée
      * Tests d'orchestrations sur l'implémentation des ports user_side
      * Tests comportementaux métiers sur l'api de l'aggrégat Offre
    * Un domaine métier riche et protégé 
      * inversion de dépendance
      * Pas de record => on évite les getters/setters et on privilégie l'orienté objet les principes du tell don't ask 'tell don't ask'
      * Mise en place d'aggregats, d'entités et de value object
      * On redéfinit les méthodes equals à partir des UUID pour les entités (au sens DDD)
      * On redéfinit les méthodes equals à partir de la valeur des attributs pour les values objects


### Reste à faire 
* Finir le premier use case
* Eclaircir de nombreux points fonctionnels (d'où vient le floor Price ? la quantité produite par bloc correspond-elle aux parcs associés ? etc.)
* Refactoring des test (principalement en extrayant les 'expected' attendus pour plus de lisibilité)
* Gestion des droits
* Créer et harmoniser les retours d'erreur pour les apis en suivant la norme RFC 9457
* etc.
