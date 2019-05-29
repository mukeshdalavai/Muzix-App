FROM openjdk:11-jdk-stretch

ADD /target/spring-config-server-0.0.1-SNAPSHOT.jar /src/app/spring-config-server-0.0.1-SNAPSHOT.jar

WORKDIR /src/app

ENTRYPOINT ["java","-jar","spring-config-server-0.0.1-SNAPSHOT.jar"]