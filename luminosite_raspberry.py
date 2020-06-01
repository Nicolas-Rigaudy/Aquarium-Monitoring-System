import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)                                 #permet d'éviter les messages d'avertissement
LIGHT_PIN = 23
GPIO.setup(LIGHT_PIN, GPIO.IN)                          #définit la broche comme une broche d'entrée (ici on prend la brpche GPIO 23 (n°16)
lOld = not GPIO.input(LIGHT_PIN)                        #utilisation d'une variable lOld pour sauvegarder le dernier état du capteur (pour pouvoir la comparer ensuite)

print("Début du module de capteur de luminosité")
time.sleep(0.5)                                         #attente de 0,5s pour être sur que le capteur est stabilisé

while True:                                             #début de la boucle à l'infini
    if GPIO.input(LIGHT_PIN) != lOld:                   #si le signal différent du dernier état mesuré
        if GPIO.input(LIGHT_PIN):                       #si le signal est 1 --> intensité de lumière faible
            print ("c'est éteint ! \u263e")
        else:                                           #sinon intensité de lumière forte
            print ("c'est allumé ! \u263c")
        lOld = GPIO.input(LIGHT_PIN)                    #sauvegarde du dernier état mesuré dans la variable lOld
        time.sleep(2.5)                                 #attente de 2,5s avant de pousuivre la boucle (après diff tests, aucune erreur avec ce lapse de tps)



