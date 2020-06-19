#Code qui permet d'enregistrer la temperature dans un fichier

import time
import datetime


def lireFichier (emplacement) :
    #ouverture fichier contenant la temp
    fichTemp = open(emplacement)
    #lecture fichier
    contenu = fichTemp.read()
    #Fermeture fichier apres qu'il ait ete lu
    fichTemp.close()
    return contenu

def recupTemp (contenuFich) :
    #Supprimer la premiere ligne qui est inutile
    secondeLigne = contenuFich.split("\n")[1]
    temperatureData = secondeLigne.split(" ")[9]
    #Supprimer le "t="
    temperature = float(temperatureData[2:])
    #Mettre un chiffre après la virgule
    temperature = temperature / 1000
    return temperature

def sauvegarde (temperature, date, emplacement) :
    fichierSauvegarde = open(emplacement, "a")
    fichierSauvegarde.write(str(date)+"   ")
    fichierSauvegarde.write(str(temperature)+'\r\n')
    fichierSauvegarde.close()

while True :
    date = datetime.datetime.now().strftime('%d-%m-%Y %H:%M:%S')
    contenuFich = lireFichier("/sys/bus/w1/devices/28-01145e82fa41/w1_slave")
    temperature = recupTemp (contenuFich)
    sauvegarde(temperature, date, "Temperature.txt")
    time.sleep(60)
    

#print ("Temperature :", temperature)
