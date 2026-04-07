# WhatsApp Chatbot Backend

A WhatsApp chatbot backend simulation built with **Java Spring Boot**.

## Developer
**Abdul Qadir** — B.Tech AI & ML, DPGITM Gurugram

---

## Tech Stack
- Java 17
- Spring Boot 3.2
- Maven
- Docker

---

## API Endpoints

### POST /webhook
Receive a WhatsApp message and get a bot reply.

**Request:**
```json
{
  "from": "919876543210",
  "message": "Hi"
}
```

**Response:**
```json
{
  "to": "919876543210",
  "reply": "Hello! How can I help you today?"
}
```

### Supported Messages
| Input | Reply |
|-------|-------|
| Hi / Hello / Hey | Hello! How can I help you today? |
| Bye / Goodbye | Goodbye! Have a great day! |
| Help | Available commands: Hi, Bye, Help, About |
| About | I am a WhatsApp Chatbot Backend... |
| Anything else | Sorry, I did not understand that. |

---

### GET /logs
Returns all logged messages.

### GET /health
Health check — returns service status.

---

## Run Locally

### Without Docker
```bash
mvn spring-boot:run
```

### With Docker
```bash
docker build -t whatsapp-bot .
docker run -p 8080:8080 whatsapp-bot
```

---

## Test with curl

```bash
# Hi message
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"from": "919876543210", "message": "Hi"}'

# Bye message
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"from": "919876543210", "message": "Bye"}'

# View logs
curl http://localhost:8080/logs

# Health check
curl http://localhost:8080/health
```

---

## Project Structure

```
whatsapp-bot/
├── src/main/java/com/chatbot/api/
│   ├── ChatbotApplication.java   ← Entry point
│   ├── WebhookController.java    ← REST endpoints
│   ├── BotService.java           ← Reply logic
│   ├── MessageLogger.java        ← Message logging
│   ├── WhatsAppMessage.java      ← Request model
│   └── ChatbotResponse.java      ← Response model
├── src/main/resources/
│   └── application.properties
├── Dockerfile
└── pom.xml
```
