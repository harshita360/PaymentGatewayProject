FROM openjdk:17-alpine
EXPOSE 8080
ADD target/payment-gateway.jar payment-gateway.jar
ENTRYPOINT ["java","-jar","/payment-gateway.jar"] 

