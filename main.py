from sensor import Sensor
from temperature import Temperature
from brightness import Brightness

def main():

    sensorlist = []

    temperatureSensor = Temperature(1)
    brightnessSensor = Brightness(2)

    sensorlist.append(temperatureSensor)
    sensorlist.append(brightnessSensor)

    for sensor in sensorlist:
        sensor.getData()
        sensor.sendData()

if __name__ == "__main__":
    main()
