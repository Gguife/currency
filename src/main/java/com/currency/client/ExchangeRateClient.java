package com.currency.client;

import com.currency.model.response.ExchangeRateResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {
    private final Dotenv dotenv = Dotenv.load();

    private final String apiKey = dotenv.get("APY_KEY");
    private static final String baseUrl = "https://v6.exchangerate-api.com/v6";
    private final HttpClient client = HttpClient.newHttpClient();

    public double getExchangeRate(String fromCurrency, String toCurrency) {
        String url = String.format("%s/%s/pair/%s/%s", baseUrl, apiKey, toCurrency, fromCurrency);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200) {
                Gson gson = new Gson();
                ExchangeRateResponse rateResponse = gson.fromJson(response.body(), ExchangeRateResponse.class);
                return rateResponse.getConversion_rate();
            }else {
                throw new RuntimeException("Error API: code" + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error accessing Exchange API: " + e.getMessage());
        }
    }

}
