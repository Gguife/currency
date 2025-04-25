package com.currency.service;

import com.currency.client.ExchangeRateClient;
import com.currency.model.response.CurrencyConversionResult;

public class CurrencyConverterService {
    private final ExchangeRateClient exchangeRateClient;

    public CurrencyConverterService(ExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    public CurrencyConversionResult convert(String fromCurrency, String toCurrency, double amount) {
        double rate = exchangeRateClient.getExchangeRate(fromCurrency, toCurrency);
        double converted = amount * rate;

        return new CurrencyConversionResult(converted, rate);
    }
}
