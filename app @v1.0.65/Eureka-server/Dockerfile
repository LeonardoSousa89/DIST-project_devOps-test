FROM openjdk:11

VOLUME /tmp

EXPOSE 8761  

ADD ./target/Eureka-server-0.0.1-SNAPSHOT.jar Eureka-server.jar

ENTRYPOINT ["java","-jar","/Eureka-server.jar"]

