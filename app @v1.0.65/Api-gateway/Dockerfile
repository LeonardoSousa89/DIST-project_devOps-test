FROM openjdk:11

VOLUME /tmp

EXPOSE 8765  

ADD ./target/Api-gateway-0.0.1-SNAPSHOT.jar Api-gateway.jar

ENTRYPOINT ["java","-jar","/Api-gateway.jar"]

