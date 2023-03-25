FROM openjdk:8-jdk-alpine
RUN mkdir -p TechnicalJava
COPY target/TechnicalJava-0.0.1-SNAPSHOT.jar TechnicalJava/TechnicalJava.jar
EXPOSE 8080 1521 81 22
WORKDIR TechnicalJava
ENTRYPOINT ["java","-jar","TechnicalJava.jar","-web -webAllowOthers -webPort 81 -tcp -tcpAllowOthers  tcpPort 1521 -browser"]
