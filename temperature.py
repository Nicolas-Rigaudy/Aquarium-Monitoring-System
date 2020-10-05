from sensor import Sensor
import requests
import tools

class Temperature(Sensor):

    def __init__(self, sensorID):
        self.sensortype = "temperature"
        self.sensorID = sensorID

    def lireFichier (self, emplacement) :
        self.fichTemp = open(emplacement)
        self.contenu = self.fichTemp.read()
        self.fichTemp.close()
        print("Fichier lu correctement")
        return self.contenu

    def recupTemp (self, contenuFich) :
        self.secondeLigne = contenuFich.split("\n")[1]
        self.temperatureData = self.secondeLigne.split(" ")[9]
        self.temperature = float(self.temperatureData[2:])
        self.temperature = self.temperature / 1000
        print("Temperature recuperee correctement")
        return self.temperature

    def getData(self):

        self.contenuFich1 = self.lireFichier("/sys/bus/w1/devices/28-011453f479aa/w1_slave")
        self.contenuFich2 = self.lireFichier("/sys/bus/w1/devices/28-01145e82fa41/w1_slave")

        self.temperature1 = self.recupTemp(self.contenuFich1)
        self.temperature2 = self.recupTemp(self.contenuFich2)

        print ("Temperature Capteur #1 : ", self.temperature1)
        print ("Temperature Capteur #2 : ", self.temperature2)

        self.tempDiff = self.temperature2 - self.temperature1

        if self.tempDiff < 10.0 and self.tempDiff > -10.0:
            self.moyenne = (self.temperature1 + self.temperature2)/2
        else:
            self.moyenne = self.temperature1
        print ("La moyenne mesuree par les deux sondes est egale a : ", self.moyenne)

        self.data = self.moyenne

    def sendData(self):
        self.url = "http://163.172.166.95/temperature/"
        self.timestamp = tools.dateTime()
        #POST REQUEST
        self.tempData = {'data':'{"timestamp":"'+ str(self.timestamp) +'","temperature":'+ str(self.data) +'}'}
        self.r = requests.post(self.url, data = self.tempData)
        self.response = self.r.text
        print(self.response)













