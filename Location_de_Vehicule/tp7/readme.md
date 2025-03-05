# TP7 Agence de location

## Auteurs
Travail réalisé par KADIEBWE Emmanuel et BAGNAN Elna


### Objectifs et etat du code

L'objectif du tp était de gérer une agence de location de voitures en régissant les clients, les voitures qui s'y trouvent  ou encore l'affichage des voitures en fonction des filtres donnés. 
Toutes les méthodes sont fonctionnelles et ne présentent aucune erreur.


## Experiences acquises

Ce tp nous a permi d'introduire les notions de collections, d'héritage, de tables et de maps vues précédement en td notamment pour la gestion des filtres. Nous avons donc pu voir l'utilité d'un héritage ainsi que quand et pourquoi en faire usage dans certains cas.


## Difficulté

Aucune difficulté particulière

## Ligne de commandes

### La javadoc
Dans le dossier tp7:

javadoc -sourcepath src -subpackages rental -d docs


### compilation des codes
Dans le dossier tp7

javac -sourcepath src src/rental/filter/*.java -d classes

javac -sourcepath src src/rental/*.java -d classes

### Execution du main

Dans le dossier tp7

java -classpath classes rental.MainAgency

### Compilation et execution des tests
dans le dossier tp7:

compiler:

javac -classpath junit-console.jar:classes test/rental/filter/*.java

javac -classpath junit-console.jar:classes test/rental/*.java


executer :


java -jar junit-console.jar -classpath test:classes -scan-classpath


### Creation et execution du jar 

dans le tp7 

creation :
jar cvfe rental.jar rental.MainAgency -C classes rental


execution :
java -jar rental.jar  
