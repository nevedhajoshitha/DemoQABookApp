FROM maven:3.9.5-eclipse-temurin-17
WORKDIR /app
COPY . /app
CMD ["mvn", "clean", "test"]