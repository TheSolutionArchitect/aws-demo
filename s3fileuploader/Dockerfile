FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/s3fileuploader*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]