# Utiliza una imagen base de Java
FROM eclipse-temurin:20-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

VOLUME /tmp
# Copia el archivo JAR de tu aplicación al contenedor
COPY build/libs/proyectoBanco-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto en el que la aplicación escucha
EXPOSE 8080

# Crea un directorio para imágenes (si es necesario)
RUN mkdir -p /img

# Establece el comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]