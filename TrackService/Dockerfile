FROM openjdk:11-jdk-stretch

ADD /target/TrackService-0.0.1-SNAPSHOT.jar /src/app/track/TrackService-0.0.1-SNAPSHOT.jar

WORKDIR /src/app/track

ENTRYPOINT ["java","-jar","TrackService-0.0.1-SNAPSHOT.jar"]