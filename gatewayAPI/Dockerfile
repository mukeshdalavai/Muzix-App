FROM openjdk:11-jdk-stretch

ADD /target/gatewayAPI-0.0.1-SNAPSHOT.jar /src/app/gatewayAPI-0.0.1-SNAPSHOT.jar

WORKDIR /src/app

ENTRYPOINT ["java","-jar","gatewayAPI-0.0.1-SNAPSHOT.jar"]