import time
from w1thermsensor import W1ThermSensor
sensor = W1ThermSensor()

while True:
    temperature = sensor.get_temperature()
    print("La température actuelle de l'aquarium est de %s°C." % temperature)
    time.sleep(1)
    
