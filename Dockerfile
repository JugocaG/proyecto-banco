FROM eclipse-temurin:20-jdk
COPY build/libs/proyectoBanco-0.0.1-SNAPSHOT-plain.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
