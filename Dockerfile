# builder
FROM quay.io/quarkus/centos-quarkus-maven:19.3.1-java11 AS build
WORKDIR /app
COPY src ./src
COPY pom.xml .
USER root
RUN chown -R quarkus .
USER quarkus
RUN mvn -Pnative clean package

FROM registry.access.redhat.com/ubi8/ubi-minimal
WORKDIR /app
COPY --from=build ./target/*-runner /app/engine
RUN chmod 775 /app
EXPOSE 8080
CMD ["./engine", "-Dquarkus.http.host=0.0.0.0"]