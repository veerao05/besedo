FROM openjdk:8-jdk-alpine
RUN mkdir -p Besedo
COPY target/besedo-0.0.1-SNAPSHOT.jar Besedo/besedo.jar
EXPOSE 8080 1521 81 22
WORKDIR Besedo
ENTRYPOINT ["java","-jar","besedo.jar","-web -webAllowOthers -webPort 81 -tcp -tcpAllowOthers  tcpPort 1521 -browser"]
