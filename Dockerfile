FROM eclipse-temurin:20-jdk
#COPY build/libs/proyectoBanco-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
ENV IMG_PATH=/img
ADD build/libs/proyectoBanco-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN mkdir -p /img
ENTRYPOINT ["java", "-jar", "/app.jar"]