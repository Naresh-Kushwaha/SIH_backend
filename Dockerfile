FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/SIH1613-0.0.1-SNAPSHOT.jar SIH1613.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","SIH1613.jar"]
