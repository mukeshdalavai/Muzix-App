FROM openjdk:11-jdk-stretch

ADD /target/spring-eureka-server-0.0.1-SNAPSHOT.jar /src/app/spring-eureka-server-0.0.1-SNAPSHOT.jar

WORKDIR /src/app

ENTRYPOINT ["java","-jar","spring-eureka-server-0.0.1-SNAPSHOT.jar"]