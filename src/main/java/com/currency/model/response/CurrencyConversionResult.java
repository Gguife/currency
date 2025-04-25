package com.currency.model.response;

public class CurrencyConversionResult {
    private double convertedAmount;
    private double exchangeRate;

    public CurrencyConversionResult(double convertedAmount, double exchangeRate) {
        this.convertedAmount = convertedAmount;
        this.exchangeRate = exchangeRate;
    }


    public double getConvertedAmount() {
        return convertedAmount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "The conversion value: " + convertedAmount + " (Rate: " + exchangeRate + ")";
    }
}
