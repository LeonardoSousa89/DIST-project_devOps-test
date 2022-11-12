FROM openjdk:11

VOLUME /tmp

EXPOSE 8761  

ADD ./target/Eureka-server-0.0.1-SNAPSHOT.jar   leozin89/dist-eureka-server.jar

ENTRYPOINT ["java","-jar","leozin89/dist-eureka-server.jar"]

