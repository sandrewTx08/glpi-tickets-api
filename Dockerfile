FROM maven:3.9.6-eclipse-temurin-21-alpine
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/glpi-tickets-0.0.1-SNAPSHOT.jar"]
