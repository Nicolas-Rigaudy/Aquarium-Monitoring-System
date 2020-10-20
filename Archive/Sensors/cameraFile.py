#Enregistrement d'un fichier vidéo d'une durée de 60s via la caméra


from picamera import PiCamera
from time import sleep

camera = PiCamera()

camera.resolution = (1920, 1080)
camera.framerate = 15


camera.start_preview()
camera.start_recording('/home/pi/recordedVideo.h264')
sleep(60)
camera.stop_recording()
camera.stop_preview()
