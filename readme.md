##Dockeriser ce service
- ajouter un fichier Dockerfile (attention, la casse dans le nom du fichier est importante)

création du fichier Dockerfile à la racine du projet distanceService

insertion des infos suivantes :

FROM java:8-jdk-alpine

MAINTAINER heloise

COPY target/distance-0.0.1-SNAPSHOT.jar distance-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/distance-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080

- création du jar de distanceService

mvn clean package

- création de l’image docker via la commande

docker build --tag=distance:latest .

(le tag doit être en miniscule)

- lancement de l’image via la commande

docker run -p5000:8080 distance:latest

l’image tourne sur le port 5000 à l’adresse localhost:5000
