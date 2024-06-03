FROM openjdk:21-oracle
WORKDIR /opt/spring-app
COPY build/libs/redis-cache-0.0.1-SNAPSHOT.jar spring-app.jar
EXPOSE 8089
CMD ["java", "-jar", "spring-app.jar"]