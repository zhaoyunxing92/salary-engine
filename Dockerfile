# builder
FROM quay.io/quarkus/centos-quarkus-maven:19.3.1-java11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
USER root
RUN chown -R quarkus /usr/src/app
USER quarkus
RUN mvn -f /usr/src/app/pom.xml -Pnative clean package

FROM registry.access.redhat.com/ubi8/ubi-minimal
WORKDIR /app
COPY --from=build /usr/src/app/target/*-runner /app/engine
RUN chmod 775 /app
EXPOSE 8080
CMD ["./engine", "-Dquarkus.http.host=0.0.0.0"]