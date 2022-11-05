FROM openjdk:11

VOLUME /tmp

EXPOSE 8762  

ADD ./target/User-0.0.1-SNAPSHOT.jar user.jar

ENTRYPOINT ["java","-jar","/user.jar"]

