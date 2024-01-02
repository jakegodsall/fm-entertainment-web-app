FROM amazoncorretto:21-alpine

WORKDIR /backend

COPY target/fm-entertainment-web-app-backend-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/backend/myapp.jar"]