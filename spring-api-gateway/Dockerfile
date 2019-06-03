FROM openjdk:11-jdk-stretch

ADD /target/spring-api-gateway-0.0.1-SNAPSHOT.jar /src/app/spring-api-gateway-0.0.1-SNAPSHOT.jar

WORKDIR /src/app
EXPOSE 8050
ENTRYPOINT ["java","-jar","spring-api-gateway-0.0.1-SNAPSHOT.jar"]