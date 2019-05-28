FROM openjdk:11-jdk-stretch

ADD /target/MuzixApplication-0.0.1-SNAPSHOT.jar /src/app/music/MuzixApplication-0.0.1-SNAPSHOT.jar

WORKDIR /src/app/music

ENTRYPOINT ["java","-jar","MuzixApplication-0.0.1-SNAPSHOT.jar"]