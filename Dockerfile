# builder
FROM registry.access.redhat.com/ubi8/ubi-minimal:8.1 AS build
WORKDIR /app
COPY src ./src
COPY pom.xml .
USER root
RUN chown -R quarkus .
USER quarkus
RUN mvn package -Pnative -Dquarkus.native.container-build=true -DskipTests

FROM registry.access.redhat.com/ubi8/ubi-minimal:8.1
WORKDIR /app
COPY --from=build ./target/*-runner /app/engine
RUN chmod 775 /app
EXPOSE 8080
CMD ["./engine", "-Dquarkus.http.host=0.0.0.0"]