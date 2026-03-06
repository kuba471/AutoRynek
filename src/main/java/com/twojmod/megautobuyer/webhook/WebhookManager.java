package com.twojmod.megautobuyer.webhook;

import com.twojmod.megautobuyer.utils.ModLogger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WebhookManager {
    private final HttpClient client = HttpClient.newHttpClient();

    public void sendSimpleMessage(String webhookUrl, String content) {
        try {
            String json = "{\"content\":\"" + content.replace("\"", "\\\"") + "\"}";
            HttpRequest request = HttpRequest.newBuilder(URI.create(webhookUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                    .build();
            client.sendAsync(request, HttpResponse.BodyHandlers.discarding());
        } catch (Exception e) {
            ModLogger.error("Webhook send failed", e);
        }
    }
}
