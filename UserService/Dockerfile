FROM openjdk:11-jdk-stretch

ADD /target/UserService-0.0.1-SNAPSHOT.jar /src/app/UserService-0.0.1-SNAPSHOT.jar

WORKDIR /src/app

ENTRYPOINT ["java","-jar","UserService-0.0.1-SNAPSHOT.jar"]