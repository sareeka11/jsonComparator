package com.practice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCommunicator {
    public HttpResponse<String> getResponse(String endpoint) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public String getResponseBody(String endPoint) throws IOException, InterruptedException {
        HttpResponse<String> response = getResponse(endPoint);
        if(response != null)
            return getResponse(endPoint).body();
        return null;
    }
}
