FROM openjdk:8-jdk-alpine
RUN mkdir -p besedo
COPY target/besedo-0.0.1-SNAPSHOT.jar besedo/besedo.jar
EXPOSE 8080
WORKDIR besedo
ENTRYPOINT ["java","-jar","besedo.jar","-web -webAllowOthers -tcp -tcpAllowOthers  -browser"]
