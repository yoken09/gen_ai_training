package com.epam.training.gen.ai.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
public class SemanticKernelClient {
    public String getResponse(String requestPayload)  {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://ai-proxy.lab.epam.com/openai/deployments/dall-e-3/chat/completions?api-version=2023-12-01-preview"))
                    .headers("Content-Type", "application/json")
                    .header("Api-Key", "dial-dafr65t96qoedn7ln9q0wuk0omd")
                    .POST(HttpRequest.BodyPublishers.ofString(requestPayload))
                    .build();

        HttpResponse<String> response =  HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        log.info("Chat Response : {} ", response);
        return response.body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
