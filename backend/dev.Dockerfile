FROM openjdk:21-jdk-slim

WORKDIR /backend

COPY mvnw ./
COPY .mvn ./.mvn
COPY pom.xml ./

RUN chmod +x ./mvnw
RUN ./mvnw spring-boot:repackage

COPY src /src

EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]