FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/plan-micro.jar plan-micro.jar
EXPOSE 8080
CMD ["java","-jar","plan-micro.jar"]