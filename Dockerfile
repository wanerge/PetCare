# Usamos una imagen base con OpenJDK 21
FROM openjdk:21-jdk-slim AS build

# Establecemos el directorio de trabajo en el contenedor
WORKDIR /app

# Copiamos el archivo pom.xml y el directorio de código fuente para el proceso de compilación
COPY pom.xml /app
COPY src /app/src

# Usamos Maven para construir el proyecto
RUN apt-get update && apt-get install -y maven
RUN mvn clean install -DskipTests

# Imagen base para el contenedor de ejecución
FROM openjdk:21-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiamos el JAR generado en el contenedor de ejecución
COPY --from=build /app/target/petCare-0.0.1-SNAPSHOT.jar /app/petCare.jar

# Exponemos el puerto 8080 (ajustable según la configuración)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/petCare.jar"]
