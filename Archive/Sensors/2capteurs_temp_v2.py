#Code qui permet d'enregistrer dans un fichier la température moyenne de deux capteurs

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

def sauvegarde (temperature, date, emplacement) :
    fichierSauvegarde = open(emplacement, "a")
    fichierSauvegarde.write(str(date)+"   ")
    fichierSauvegarde.write(str(temperature)+'\r\n')
    fichierSauvegarde.close()

while True :
    date = datetime.datetime.now().strftime('%d-%m-%Y %H:%M:%S')
    
    contenuFich1 = lireFichier("/sys/bus/w1/devices/28-01145e82fa41/w1_slave")
    contenuFich2 = lireFichier("/sys/bus/w1/devices/28-011453f479aa/w1_slave")

    temperature1 = recupTemp (contenuFich1)
    temperature2 = recupTemp (contenuFich2)

    moyTemp = (temperature1 + temperature2)/2

    sauvegarde(moyTemp, date, "MoyTemperature.txt")    
    time.sleep(60)
