FROM openjdk:11

VOLUME /tmp

EXPOSE 8762  

ADD ./target/User-0.0.1-SNAPSHOT.jar   leozin89/dist-user.jar

ENTRYPOINT ["java","-jar","leozin89/dist-user.jar"]

