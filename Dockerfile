FROM bellsoft/liberica-openjdk-debian:21
WORKDIR /app

COPY build/libs/MidtermSE-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
