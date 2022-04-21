FROM openjdk:11
EXPOSE 8005
ARG JAR_FILE=target/microservice-client-movements-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]