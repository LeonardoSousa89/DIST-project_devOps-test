FROM openjdk:11

VOLUME /tmp

EXPOSE 8761  

RUN ./target/Eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar

ENTRYPOINT ["java","-jar","/eureka-server.jar"]

