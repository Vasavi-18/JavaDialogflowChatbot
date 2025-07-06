package com.vasavi.chatbot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Replace with your actual GCP project ID
            String projectId = "vasavichatbotproject";
            DialogflowClient bot = new DialogflowClient(projectId);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("You: ");
                String userMessage = scanner.nextLine();
                
                if (userMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Bot: Goodbye! 👋");
                    break;
                }

                String response = bot.detectIntent(userMessage);
                System.out.println("Bot: " + response);
            }

            scanner.close();

        } catch (Exception e) {
            System.err.println("Error starting chatbot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
