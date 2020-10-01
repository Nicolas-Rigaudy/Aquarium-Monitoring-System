from sensor import Sensor
import requests
import tools
import RPi.GPIO as GPIO
import time

class Brightness(Sensor):

    def __init__(self, sensorID):
        self.sensortype = "brightness"
        self.sensorID = sensorID

    def getData(self):
        GPIO.setmode(GPIO.BCM)
        GPIO.setwarnings(False)                                 
        self.LIGHT_PIN = 23
        GPIO.setup(self.LIGHT_PIN, GPIO.IN)                          
        self.lOld = not GPIO.input(self.LIGHT_PIN)                        

        print("Debut du module de capteur de luminosite")
        time.sleep(0.5)     

        if GPIO.input(self.LIGHT_PIN) != self.lOld:   
            if GPIO.input(self.LIGHT_PIN):                           
                print ("c'est eteint !")
                self.data = 0
            else:                                               
                print ("c'est allume !")
                self.data = 100
            self.lOld = GPIO.input(self.LIGHT_PIN)                        

    def sendData(self):
        self.url = "http://163.172.166.95/luminosite/"
        self.timestamp = tools.dateTime()
        #POST REQUEST
        self.brightnessData = {'data':'{"timestamp":"'+ str(self.timestamp) +'","luminosite":'+ str(self.data) +'}'}
        self.r = requests.post(self.url, data = self.brightnessData)
        self.response = self.r.text
        print(self.response)
        #print(self.brightnessData)








