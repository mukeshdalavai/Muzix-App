FROM openjdk:11-jdk-stretch

ADD /target/gatewayAPI-0.0.1-SNAPSHOT.jar /src/app/gatewayAPI-0.0.1-SNAPSHOT.jar

WORKDIR /src/app
EXPOSE 8050
ENTRYPOINT ["java","-jar","gatewayAPI-0.0.1-SNAPSHOT.jar"]