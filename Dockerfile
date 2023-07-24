FROM openjdk:17
EXPOSE 8088
ADD target/order-service-0.0.1-SNAPSHOT.jar order-service
ENTRYPOINT ["java","-jar","order-service"]