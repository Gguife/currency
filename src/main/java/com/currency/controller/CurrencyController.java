package com.currency.controller;

import com.currency.model.request.CurrencyConversionRequest;
import com.currency.model.response.CurrencyConversionResult;
import com.currency.service.CurrencyConverterService;

public class CurrencyController {
    private final CurrencyConverterService converterService;


    public CurrencyController(CurrencyConverterService converterService) {
        this.converterService = converterService;
    }

    public void convertCurrency(CurrencyConversionRequest request) {
        CurrencyConversionResult result = converterService.convert(
                request.getFromCurrency(),
                request.getToCurrency(),
                request.getAmount()
        );

        System.out.println(result);
    }
}
