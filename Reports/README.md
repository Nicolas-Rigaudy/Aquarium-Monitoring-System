# Aquarium Monitoring System

## OUR PROJECT
As a 4th year engineering project in the IoT major, we were first given a list of sample projects we could work on. However, the idea of an aquarium fish health monitoring system was already in our minds and we decided to go forward with our own project after getting approval from our teachers. Achille’s father is passionate about fish and owns a big reef tank with 8 fish from 6 different species and this was the perfect test subject for our system. Being ourselves passionate with new technologies and connected systems, we wanted to make a smart monitoring system that can be adapted and scaled very easily to different aquarium tanks, for professionals or individuals.
The first information we wanted the system to give the user was through image recognition of the fish. Using a camera, we wanted to be able to count the fish and differentiate the species so that we could show the user each fish separately to keep track on its appearance (a lot of health problems can have visual symptoms on the fish).
We then decided to add sensors to our project such as temperature and brightness because factors like those are very important for fish and coral health. 
Finally, we chose to create an Android app especially for individuals, but also usable by professionals, which would allow the user to access in a smart, intuitive and entertaining way all of the data and information about his aquarium. 
To bring this project to life, we had all the necessary tools at our disposal, including:
*	Raspberry Pi nano computer
*	Camera module
*	Temperature and brightness sensors
*	Programming languages and software that we had already learned in class to build the code for the app and for the sensors
*	Test aquarium


## Cloud
We used a Scaleway instance to host our database. In this manner, the data could come directly from the raspberry Pi and be sent to the Android app through the cloud. This enabled us to protect our data from potential crashes of the Raspberry Pi and to create a simpler link between all our project elements.

### Ansible/Terraform/Packer
In order to manage this instance dynamically and make it so that it could easily be reproduced, we used three tools: Terraform, Ansible and Packer.
Terraform enables us to create new instances via Scaleway in case our main instance crashes or gets destroyed. Then Packer loads this instance with a template image and launches Ansible, which provisions our instance with all the required dependencies and rebuilds our database using an SQL dump. Packer finishes off by taking a new image of the configured instance.