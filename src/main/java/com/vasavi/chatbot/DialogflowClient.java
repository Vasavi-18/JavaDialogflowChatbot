package com.vasavi.chatbot;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.dialogflow.v2.*;
import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DialogflowClient {

    private final SessionsClient sessionsClient;
    private final SessionName session;

    public DialogflowClient(String projectId) throws IOException {
        String credentialsPath = "src/main/resources/service-account.json"; // adjust if needed
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(credentialsPath));
        SessionsSettings sessionsSettings = SessionsSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build();
        sessionsClient = SessionsClient.create(sessionsSettings);

        String sessionId = UUID.randomUUID().toString();
        session = SessionName.of(projectId, sessionId);
    }

    public String detectIntent(String text) {
        try {
            TextInput.Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode("en-US");
            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

            DetectIntentRequest request = DetectIntentRequest.newBuilder()
                    .setSession(session.toString())
                    .setQueryInput(queryInput)
                    .build();

            DetectIntentResponse response = sessionsClient.detectIntent(request);
            return response.getQueryResult().getFulfillmentText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry, I couldn't understand.";
        }
    }

    public void shutdown() throws InterruptedException {
        if (sessionsClient != null) {
            sessionsClient.shutdownNow();
            sessionsClient.awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
