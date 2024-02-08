FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/AFTAS-0.0.1-SNAPSHOT.jar .

ENV MYSQL_HOST=host.docker.internal

COPY src/main/resources/application.properties .

EXPOSE 8080

CMD ["java", "-jar", "AFTAS-0.0.1-SNAPSHOT.jar"]