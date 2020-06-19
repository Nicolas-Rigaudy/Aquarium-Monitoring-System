#Code qui permet d'afficher la température de deux capteurs ainsi que la moyenne

import time
import datetime

def lireFichier (emplacement) :
    fichTemp = open(emplacement)
    contenu = fichTemp.read()
    fichTemp.close()
    return contenu

def recupTemp (contenuFich) :
    secondeLigne = contenuFich.split("\n")[1]
    temperatureData = secondeLigne.split(" ")[9]
    temperature = float(temperatureData[2:])
    temperature = temperature / 1000
    return temperature

contenuFich1 = lireFichier("/sys/bus/w1/devices/28-01145e82fa41/w1_slave")
contenuFich2 = lireFichier("/sys/bus/w1/devices/28-011453f479aa/w1_slave")

temperature1 = recupTemp (contenuFich1)
temperature2 = recupTemp (contenuFich2)

print ("Temperature Capteur #1 : ", temperature1)

print ("Temperature Capteur #2 : ", temperature2)

moyenne = (temperature1 + temperature2)/2
print ("La moyenne mesurée par les deux sondes est égale à : ", moyenne)
