# TP jeu de l'oie
 Emmanuel Kadiebwe

## Presentation
Le but de ce tp est de créer un jeu de l'oie

## Remarque importante
Pour une raison que je n'ai pas réussi à résoudre, il est possible que les cases occupés ne fonction pas toujours correctement et soit comptabilisé comme occupés alors qu'elles sont vide

Exemple:
player3 is on the cell 33, throws 7 and reaches 40
player3 is on a normal cell and so jumps to 40

EM is on the cell 29, throws 6 and reaches 35
EM is on a normal cell and so jumps to 35
cell is busy, player3 is sent to cell 29


Loïc is on the cell 34, throws 6 and reaches 40
Loïc is on a normal cell and so jumps to 40
cell is busy, player3 is sent to cell 34

suite de la remarque: ceci apparait surtout quand il y a 3 joueurs ou plus

## generation de la documentation
javadoc -classpath src -d docs -subpackages goosegame

## compilation:
_tp_poo\tp8>javac -classpath src -d classes src/goosegame/Game.java

## exécution du programme
2 joueurs:  
\tp8> java -classpath classes goosegame.GameMain Loïc Emmanuel

3 joueurs:  
\tp8> java -classpath classes goosegame.GameMain Loïc Emmanuel MrRoutier

## creation du jar:
\tp8> jar cvfe goose.jar goosegame.GameMain -C classes goosegame


## Execution du jar:
tp_poo\tp8> java -jar goose.jar Loïc Emmanuel
tp_poo\tp8> java -jar goose.jar Loïc Emmanuel MrRoutier