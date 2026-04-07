# ── Stage 1: Build ──────────────────────────────────
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY . .
RUN mvn clean package -DskipTests

# ── Stage 2: Runtime ────────────────────────────────
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /workspace/target/whatsapp-bot.jar app.jar
EXPOSE 8080
ENV PORT=8080
ENTRYPOINT ["sh", "-c", "java -jar -Dserver.port=${PORT} app.jar"]
