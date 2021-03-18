FROM java:8-jdk-alpine
MAINTAINER heloise
COPY target/distance-0.0.1-SNAPSHOT.jar distance-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/distance-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080