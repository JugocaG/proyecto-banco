FROM eclipse-temurin:20-jdk
#COPY build/libs/proyectoBanco-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

ADD build/libs/proyectoBanco-0.0.1-SNAPSHOT.jar proyectoBanco-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "proyectoBanco-0.0.1-SNAPSHOT.jar"]