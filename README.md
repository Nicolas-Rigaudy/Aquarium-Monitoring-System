# Aquarium Monitoring System

## Notre projet
Il s'agit d'un systeme de monitoring pour aquarium qui utilise une
raspberry Pi connectée a un capteur de temperature, un capteur de
luminosité et une caméra (utilisée avec openCV pour de la
reconnaissance d'image sur les poissons) afin de collecter des
informations essentielles a la santé des poissons de l'aquarium. Les
données sont ensuite envoyées sur une app Android via une API Rest
afin que l'utilisateur puisse voir l'evolution de ces données.

## Questions


### ANSIBLE

Pour ansible, vaut-il mieux créer un script qui gere la configuration
de l'instance scaleway ou un script qui gere la configuration de la
raspberry, ou encore les deux?

Pour la raspberry, serait-il nécessaire d'avoir déja tout fini du cote
du code intégré dessus, de sa configuration et des différents
logiciels, librairies, packages a installer dessus necessaires pour
notre projet avant de pouvoir mettre cette configuration dans le code
ansible?

Je ne suis pas sur d'avoir tout a fait compris les possibilites que
nous amene ansible en termes de ce qu'il faut avoir fini avant la
configuration. Nous nous posions cette question par peur d'etre
limités sur le temps aue nous aurions a allouer a cette parie si elle
requiert que tout le reste de notre projet soit fini ou presque.


### API REST
Nous avons pour but d'utiliser une API rest, mais hélas nous sommes un
peu perdus. Nous avons d'un coté une raspberry Pi qui récupere et
analyse des informations de différents capteurs(température, vidéo,
luminosité).
De l'autre coté nous avons une application (android) qui récupere les
informations et les affiche pour que l'utilisateur puisse suivre ces
données.

>Nous étions partis en créant une API rest sur Android Studio mais
>j'ai l'impression qu'il faudrait mieux commencer par configurer notre
>instance scaleway au préalable.
>> - Quelle type d'instance devont nous prendre? (la DEV1-S sera t'elle suffisante?)
>> - J'ai vu qu'il y avait plusieurs API sur Scaleway, laquelle devons-nous
>>   prendre?
>> - De quelle maniere devrions nous faire passer nos informations de la
>>   raspberry a l'instance et ensuite a l'application ?

### Terraform et Packer

Nous nous demandions aussi quelles seraient les utilisations
possibles de terraform et packer au sein de notre projet. Seront-ils
utiles seulement pour la définition de l'instance scaleway?