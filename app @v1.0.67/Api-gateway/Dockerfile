FROM openjdk:11

VOLUME /tmp

EXPOSE 8765  

ADD ./target/Api-gateway-0.0.1-SNAPSHOT.jar leozin89/dist-api-gateway.jar

ENTRYPOINT ["java","-jar","leozin89/dist-api-gateway.jar"]

