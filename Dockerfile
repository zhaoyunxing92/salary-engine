# builder
FROM openjdk:8-jdk-alpine3.9 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
CMD ["./mvnw","clean package -DskipTests"]

FROM openjdk:8-jdk-alpine3.9 AS run
WORKDIR /app
COPY --from=build /app/target/*-runner /app/engine.jar
RUN chmod 775 /app
EXPOSE 8080
CMD ["java", "-jar engine.jar"]