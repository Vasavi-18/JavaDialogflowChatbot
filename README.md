# Java Dialogflow Chatbot 🤖💬

A terminal-based chatbot built using **Java** and **Google Dialogflow**, capable of interacting with users via natural language. This project showcases how to integrate Dialogflow with Java using service account credentials for authentication.

---

## 🚀 Features

- Conversational AI with Dialogflow
- Java console application
- Uses Google Cloud Dialogflow API
- Secure service account authentication
- Interactive CLI (Command Line Interface)

---

## 🛠️ Technologies Used

- Java 8+
- Maven
- Google Cloud Dialogflow API (v2)
- gRPC
- Google OAuth2 Auth Library

---

## 📂 Project Structure
JavaDialogflowChatbot/
│
├── src/
│ ├── main/
│ │ ├── java/com/vasavi/chatbot/
│ │ │ ├── Main.java
│ │ │ └── DialogflowClient.java
│ │ └── resources/
│ │ └── (service-account.json excluded)
│
├── target/ # Build output (ignored in Git)
├── .gitignore # Ignores secrets and build folders
├── pom.xml # Maven dependencies
└── README.md # You're reading it!
---

## 🔐 Important Note

> The `service-account.json` (Google Cloud credentials) is **excluded** from version control for security reasons.

---

## 🧪 How to Run

1. **Clone the repository**:

   ```bash
   git clone https://github.com/Vasavi-18/JavaDialogflowChatbot.git
   cd JavaDialogflowChatbot

