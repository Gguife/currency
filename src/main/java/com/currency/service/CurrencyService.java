package com.currency.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyService {
    private final Dotenv dotenv = Dotenv.load();

    private final String apiKey = dotenv.get("APY_KEY");
    private static final String baseUrl = "https://v6.exchangerate-api.com/v6";
    private final HttpClient client = HttpClient.newHttpClient();

    public void apiRequest(String currency, String currency2) {
        String url = String.format("%s/%s/pair/%s/%s", baseUrl, apiKey, currency, currency2);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            String responseApi = response.body();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement jsonElement = JsonParser.parseString(responseApi);
            String json = gson.toJson(jsonElement);
            System.out.println(json);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }



}
