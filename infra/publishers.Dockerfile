# image with dependencies to build jar
FROM openjdk:8-jdk-alpine

WORKDIR /app
COPY build.gradle.kts gradlew settings.gradle.kts /app/
COPY gradle /app/gradle
RUN ./gradlew --version

COPY . .
RUN ./gradlew --no-daemon -i shadowJar

EXPOSE 5001

CMD ["java","-jar","/app/build/libs/publishers-all.jar"]

# # Image with fat jar
# FROM openjdk:8-jdk-alpine
# WORKDIR /app
# COPY --from=build /app/build/libs/${JAR_NAME} /app/app.jar

# EXPOSE 5001

# CMD ["java","-jar","app.jar"]
