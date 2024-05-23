FROM openjdk:21-oracle
WORKDIR /opt/redis-app
COPY build/libs/redis-cache-0.0.1-SNAPSHOT.jar redis-cache.jar
EXPOSE 8089
CMD ["java", "-jar", "redis-cache.jar"]