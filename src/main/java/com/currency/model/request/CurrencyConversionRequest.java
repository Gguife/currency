package com.currency.model.request;

public class CurrencyConversionRequest {
    private String fromCurrency;
    private String toCurrency;
    private double amount;

    public CurrencyConversionRequest(String fromCurrency, String toCurrency, double amount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
    }


    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getAmount() {
        return amount;
    }
}
